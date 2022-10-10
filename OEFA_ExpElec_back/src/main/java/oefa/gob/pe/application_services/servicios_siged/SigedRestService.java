package oefa.gob.pe.application_services.servicios_siged;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.siged.*;
import oefa.gob.pe.infraestructure_cross_cuting.common.RestRequestManager;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Log4j2
@Component
public class SigedRestService {

    DTOUsuarioSiged obtenerToken(String usuario, String clave, String urlLogin) {
        Gson gson = new Gson();
        DTOUsuarioSiged respuesta = new DTOUsuarioSiged();
        JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("username", usuario);
        jsonObj.addProperty("password", clave);
        String parametro = jsonObj.toString();
        try {
            String content = RestRequestManager.postRest(urlLogin, parametro);
            respuesta = gson.fromJson(content, DTOUsuarioSiged.class);
            return respuesta;
        } catch (IOException | ExecutionException e) {
            log.error("ERROR: {}", e.getMessage());
            respuesta.status = "500";
            respuesta.message = "El servicio no está activo";
            return respuesta;
        } catch (InterruptedException e) {
            log.error("ERROR: {}", e.getMessage());
            respuesta.status = "500";
            respuesta.message = "El servicio no está activo";
            Thread.currentThread().interrupt();
            return respuesta;
        }
    }

    DTOHojaTramite buscarHojaTramite(String hojaTramite, String urlConsultaSiged, String token) {
        Gson gson = new Gson();
        DTOHojaTramite resultado = new DTOHojaTramite();
        try {
            String content = RestRequestManager.getRest(urlConsultaSiged + "expediente/numero/" + hojaTramite, token);
            resultado = gson.fromJson(content, DTOHojaTramite.class);
            return resultado;
        } catch (IOException | ExecutionException e) {
            log.error("ERROR: {}", e.getMessage());
            resultado.estado = "500";
            resultado.mensaje = "Acceso denegado al servicio";
            return resultado;
        } catch (InterruptedException e) {
            log.error("ERROR: {}", e.getMessage());
            resultado.estado = "500";
            resultado.mensaje = "Acceso denegado al servicio";
            Thread.currentThread().interrupt();
            return resultado;
        }
    }

    DTORegistroRespuesta crearRegistroPersonaNatural(DTOPersonaNatural persona, String urlConsultaSiged, String token) {
        return crearRegistroPersonaGenerica(persona, urlConsultaSiged, token);
    }

    DTORegistroRespuesta crearRegistroPersonaJuridica(DTOPersonaJuridica persona, String urlConsultaSiged, String token) {
        return crearRegistroPersonaGenerica(persona, urlConsultaSiged, token);
    }

    private <T> DTORegistroRespuesta crearRegistroPersonaGenerica(T persona, String urlConsultaSiged, String token) {
        Gson gson = new Gson();
        String parametro = gson.toJson(persona);
        DTORegistroRespuesta respuesta = new DTORegistroRespuesta();
        try {
            String content = RestRequestManager.postRESTCustomToken(urlConsultaSiged + "expediente", parametro, token);
            respuesta = gson.fromJson(content, DTORegistroRespuesta.class);
            return respuesta;
        } catch (IOException | ExecutionException e) {
            log.error(e.getMessage(), e);
            respuesta.estado = "500";
            respuesta.mensaje = "Acceso denegado al servicio";
            return respuesta;
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            respuesta.estado = "500";
            respuesta.mensaje = "Acceso denegado al servicio";
            Thread.currentThread().interrupt();
            return respuesta;
        }
    }

    DTORegistroRespuesta agregarDocumentoAndArchivo(DTODocumentoCabecera documento, String urlConsultaSiged, String token) {
        Gson gson = new Gson();
        String parametro = gson.toJson(documento);
        DTORegistroRespuesta respuesta = new DTORegistroRespuesta();
        try {
            String content = RestRequestManager.postRESTCustomToken(urlConsultaSiged + "expediente/documento", parametro, token);
            respuesta = gson.fromJson(content, DTORegistroRespuesta.class);
            if (respuesta.estado.equals("1"))
                respuesta.mensaje = "Documento guardado con éxito";
            return respuesta;
        } catch (IOException | ExecutionException e) {
            log.error(e.getMessage(), e);
            respuesta.estado = "500";
            respuesta.mensaje = "Acceso denegado al servicio";
            return respuesta;
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            respuesta.estado = "500";
            respuesta.mensaje = "Acceso denegado al servicio";
            Thread.currentThread().interrupt();
            return respuesta;
        }
    }

    DTORegistroRespuesta agregarArchivoAlDocumento(DTODocumento documento, String urlConsultaSiged, String token) {
        Gson gson = new Gson();
        String parametro = gson.toJson(documento);
        DTORegistroRespuesta respuesta = new DTORegistroRespuesta();
        try {
            String content = RestRequestManager.postRESTCustomToken(urlConsultaSiged + "expediente/documento/archivo", parametro, token);
            respuesta = gson.fromJson(content, DTORegistroRespuesta.class);
            if (respuesta.estado.equals("1"))
                respuesta.mensaje = "Archivo guardado con éxito";
            return respuesta;
        } catch (IOException | ExecutionException e) {
            log.error(e.getMessage(), e);
            respuesta.estado = "500";
            respuesta.mensaje = "Acceso denegado al servicio";
            return respuesta;
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            respuesta.estado = "500";
            respuesta.mensaje = "Acceso denegado al servicio";
            Thread.currentThread().interrupt();
            return respuesta;
        }
    }

    DTOProcesoCabecera enumerarDocumento(int idDocumento, String urlConsultaSiged, String token) {
        Gson gson = new Gson();
        DTOProcesoCabecera respuesta = new DTOProcesoCabecera();
        try {
            String content = RestRequestManager.getRest(urlConsultaSiged + "app/documento/enumerar/" + idDocumento, token);
            respuesta = gson.fromJson(content, DTOProcesoCabecera.class);
            return respuesta;
        } catch (IOException | ExecutionException e) {
            log.error("ERROR: {}", e.getMessage());
            respuesta.estado = "500";
            respuesta.mensaje = "Acceso denegado al servicio";
            return respuesta;
        } catch (InterruptedException e) {
            log.error("ERROR: {}", e.getMessage());
            respuesta.estado = "500";
            respuesta.mensaje = "Acceso denegado al servicio";
            Thread.currentThread().interrupt();
            return respuesta;
        }
    }
}