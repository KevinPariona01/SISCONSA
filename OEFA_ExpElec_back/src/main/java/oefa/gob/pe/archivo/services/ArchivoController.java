package oefa.gob.pe.archivo.services;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.okhttp.OkHttpClient;
import io.sentry.openfeign.SentryCapability;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.archivo.application.dto.archivo.DTOArchivo;
import oefa.gob.pe.archivo.application.dto.archivo.DTOArchivoRespuesta;
import oefa.gob.pe.archivo.application.services.ArchivoAppService;
import oefa.gob.pe.infraestructure_cross_cuting.config_properties.Alfresco;
import oefa.gob.pe.infraestructure_cross_cuting.util.Helpers;
import org.apache.http.ParseException;
import org.jetbrains.annotations.NotNull;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/siee/api/archivo")
@CrossOrigin(originPatterns = {"https://*.oefa.gob.pe", "http://localhost:[*]", "http://127.0.0.1:[*]"}, allowedHeaders = "*")
@Import(FeignClientsConfiguration.class)
public class ArchivoController {

	private final ArchivoAppService archivoAppService;

	private final String restUrl;

	private final String idSistema;

	private final String user;

	private final String pass;

	private final AlfrescoRest cliente;

	public ArchivoController(Encoder encoder, Decoder decoder, final ArchivoAppService archivoAppService, final Alfresco alfresco) {
		this.archivoAppService = archivoAppService;
		restUrl = alfresco.getUrl();
		idSistema = alfresco.getApp();
		user = alfresco.getUser();
		pass = alfresco.getPass();
		String keyUrl = alfresco.getKey_url();
		cliente = Feign.builder()
		               .client(new OkHttpClient())
		               .encoder(encoder)
		               .decoder(decoder)
		               .addCapability(new SentryCapability())
		               .requestInterceptor(new BasicAuthRequestInterceptor(user, pass))
		               .target(AlfrescoRest.class, keyUrl);
	}

	@GetMapping("/saludar")
	public String saludar() {
		return "Hola, para informarte que soy estoy siendo ejecutado correctamente.";
	}

	/**
	 * =============== Alfresco ===============
	 **/

	@PostMapping("/eliminar-alfresco")
	public DTOArchivoRespuesta eliminarAlfresco(@RequestBody final DTOArchivo solicitud) {
		final DTOArchivoRespuesta respuesta = new DTOArchivoRespuesta();

		try {
			archivoAppService.eliminar(solicitud);
			respuesta.estado = true;
			respuesta.mensaje = "OK";
		} catch (final RuntimeException e) {
			respuesta.estado = false;
			respuesta.mensaje = "ERROR " + e;
			log.error(e.getMessage(), e.getCause());
			log.error("Error", e);
		}

		return respuesta;
	}

	// REST API

	@PostMapping("/agregar-alfresco")
	public DTOArchivoRespuesta agregarAlfresco2(@RequestBody DTOArchivo solicitud) {
		@NonNull String listExt = obtenerListaExtensionesPermitidas(solicitud.tipoArchivo);

		DTOArchivo solArchivo = new DTOArchivo();
		solArchivo.setAudCreadoPor(solicitud.audCreadoPor);
		Long idArchivoUnico;
		if (solicitud.opcion.equals("AGREGAR") || (solicitud.opcion.equalsIgnoreCase("MODIFICAR") && (solicitud.idArchivo == null || solicitud.idArchivo == 0))) {
			solArchivo.setNombreArchivo(solicitud.nombreArchivo);
			solArchivo.setNroFolios(solicitud.nroFolios);
			idArchivoUnico = archivoAppService.agregar(solArchivo);
		} else {
			idArchivoUnico = Long.valueOf(solicitud.idArchivo);
		}

		var folderBase = "{proyecto}{separador}registro-resultado{separador}{folderName}{separador}";

		var folder = folderBase.replace("{folderName}", Helpers.getAlfrescoFolderName()).replace("{separador}", "/").replace("{proyecto}", "MONITOREO");

		try {
			@NonNull var ticketAlfresco = cliente.loginObtenerTicket(user, pass);
			@NonNull String ticketSesion = obtenerTicketSesion();

			var bodyRequest = AlfrescoRest.RequestRegistrarParametros.builder()
			                                                         .sesTicket(ticketSesion)
			                                                         .listName("documento")
			                                                         .listExt(listExt)
			                                                         .listSize("5242880") // Porque??
			                                                         .listIdDocumento(String.valueOf(idArchivoUnico))
			                                                         .idSistema(idSistema)
			                                                         .userOefa(user)
			                                                         .pathAlfresco(folder)
			                                                         .build();

			var response = cliente.registrarParametros(ticketSesion, bodyRequest);
			if (!response.getCode().equals("00000")) {
				throw new IllegalStateException("No se pudo registrar los parametros en el alfreso \n" + response);
			}
			@NonNull var keyRegParam = response.getKey();

			var httpOriginal = cliente.obtenerHTML(ticketAlfresco, keyRegParam);
			var modhttp = httpOriginal.replace("/alfresco/s/uploadDoc/", restUrl + "/alfresco/s/uploadDoc/").replace("method=\"post\"", "target=\"_blank\" method=\"post\"");

			return DTOArchivoRespuesta.builder()
					.formActionURL(restUrl + "/alfresco/s/uploadDoc/" + keyRegParam + "?alf_ticket=" + ticketAlfresco)
					.keyh(String.valueOf(keyRegParam))
					.estado(true)
					.idArchivo(Math.toIntExact(idArchivoUnico))
			                          .archivoHtml(modhttp)
			                          .build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			if (solicitud.opcion.equals("AGREGAR")) {
				archivoAppService.eliminar(solicitud);
			} else {
				archivoAppService.eliminarById(idArchivoUnico);
			}
			return new DTOArchivoRespuesta();
		}
	}

	@NotNull
	private String obtenerListaExtensionesPermitidas(final String tipoArchivo) {
		return switch (tipoArchivo.toUpperCase()) {
			case "IMAGEN" -> ".png|.jpg|.zip|.rar";
			case "DOCUMENTO" -> ".pdf|.docx|.doc|.zip|.rar|.zip";
			case "EXCEL" -> ".pdf|.docx|.doc|.xlsx|.xls|.zip|.rar";
			default ->
					".pdf|.docx|.doc|.zip|.rar|.zip|.rar|.doc|.docx|.pdf|.xls|.xlsx|.jpg|.jpeg|.png|.avi|.flv|.mp4|.ppt|.pptx";
		};
	}

	@NotNull
	private String obtenerTicketSesion() {
		var sesion = cliente.obtenerSesion(idSistema);
		if (!sesion.getRESULTADO().equals("OK")) {
			throw new IllegalStateException("No se pudo obtener la sesion del alfresco \n" + sesion);
		}
		@NonNull var ticketSesion = sesion.getMSG();
		return ticketSesion;
	}

	@PostMapping("/consultar-alfresco")
	public DTOArchivoRespuesta consultarAlfresco2(@RequestBody final DTOArchivo solicitud) {
		final DTOArchivoRespuesta respuesta = new DTOArchivoRespuesta();
		try {
			@NonNull var ticketAlfresco = cliente.loginObtenerTicket(user, pass);
			@NonNull var ticketSesion = obtenerTicketSesion();

			var resp = cliente.obtenerLinkDescarga(solicitud.uiid, ticketSesion, idSistema, ticketAlfresco);
			if (!resp.getResult().contains("00000")) {
				throw new IllegalStateException("No se pudo obtener el link de descarga \n" + resp);
			}

			respuesta.estado = true;
			respuesta.urlDownload = resp.getDownloadUrl();
			respuesta.fullUrlDownload = restUrl + "/alfresco" + resp.getDownloadUrl();
		} catch (ParseException ex) {
			log.error(ex.getMessage(), ex);
			log.error(ex);
		}
		return respuesta;
	}

	@PostMapping("/actualizar-alfresco")
	public DTOArchivoRespuesta actualizarAlfresco(@RequestBody final DTOArchivo solicitud) {
		final DTOArchivoRespuesta respuesta = new DTOArchivoRespuesta();
		try {
			archivoAppService.actualizarAlfresco(solicitud);
			respuesta.estado = true;
			respuesta.mensaje = "OK";
		} catch (final RuntimeException e) {
			respuesta.estado = false;
			respuesta.mensaje = "ERROR " + e;
			log.error("Error", e);
		}

		return respuesta;
	}

	@PostMapping("/obtenerArchivo")
	public DTOArchivo obtenerArchivo(@RequestBody DTOArchivo d) {

		DTOArchivo archivo = null;
		try {
			archivo = archivoAppService.obtenerArchivo(d);
			if (archivo.idArchivo > 0) {
				DTOArchivoRespuesta t = consultarAlfresco2(archivo);
				archivo.urlDescarga = t.fullUrlDownload;
			}
		} catch (RuntimeException ex) {
			log.error(ex.getMessage(), ex);
		}

		return archivo;
	}

	@PostMapping("/obtenerArchivo02")
	public DTOArchivo obtenerArchivo02(@RequestBody DTOArchivo d) {

		DTOArchivo archivo = null;
		try {

			archivo = archivoAppService.obtenerArchivo02(d);

			if (archivo.idArchivo > 0) {
				DTOArchivoRespuesta t = consultarAlfresco2(archivo);
				archivo.urlDescarga = t.fullUrlDownload;
			}
		} catch (RuntimeException ex) {
			log.error(ex.getMessage(), ex);
		}

		return archivo;
	}

	@PostMapping("/quitar-fuente-propia")
	public int quitarTramiteArchivo(@RequestBody DTOArchivo d) {
		int res = 0;
		try {
			archivoAppService.quitarTramiteArchivo(d);
			res = 1;
		} catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
		return res;
	}

	@Data
	private class Tickets {
		@NonNull String session;
		@NonNull String alfresco;
	}
}
