package oefa.gob.pe.archivo.services;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.regex.Pattern;


public interface AlfrescoRest {
	Pattern MY_PATTERN = Pattern.compile("(?<=<ticket>).*(?=</ticket>)");

	@RequestLine("GET /alfresco/service/api/login?u={user}&pw={password}")
	String login(@Param("user") String user, @Param("password") String password);

	default String loginObtenerTicket(String user, String password) {
		var respuesta = this.login(user, password);
		var matecher = MY_PATTERN.matcher(respuesta);
		if (matecher.find()) {
			return matecher.group();
		} else {
			throw new IllegalStateException("No se pudo obtener el ticket del alfresco");
		}
	}

	@RequestLine("GET /carga-masiva-alfresco-ws/rest/sessionkeyws/getSessionKey/{idSistema}")
	RespuestaObtenerSesion obtenerSesion(@Param("idSistema") String idSistema);

	@RequestLine("POST /alfresco/s/regParams?alf_ticket={ticket}")
	@Headers("Content-Type: multipart/form-data")
	RespuestaRegistrarParametros registrarParametros(@Param("ticket") String ticket, RequestRegistrarParametros pojo);

	@RequestLine("GET /alfresco/s/uploadDoc/{paramKey}?alf_ticket={ticket}")
	String obtenerHTML(@Param("ticket") String ticket, @Param("paramKey") @NonNull Long paramKey);

	@RequestLine("GET /alfresco/s/downloadDoc?id={idFile}&wsTicket={wsTicket}&idSistema={idSistema}&alf_ticket={ticketAlf}")
	RespuestaSolicitudLinkDescarga obtenerLinkDescarga(@Param("idFile") String idArchivo, @Param("wsTicket") String ticketSesion, @Param("idSistema") String idSistema, @Param("ticketAlf") String ticketAlfresco);

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE)
	class RespuestaRegistrarParametros {
		String message;
		Long key;
		AlfrescoStatus status;
		String code;
		String exception;
		String callstack;
		String server;
		String time;
	}

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE)
	class AlfrescoStatus {
		int code;
		String description;
		String name;
	}

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE)
	class RespuestaObtenerSesion {
		@NonNull String MSG;
		@NonNull String RESULTADO;
	}

	@Data
	@Builder
	@FieldDefaults(level = AccessLevel.PRIVATE)
	class RequestRegistrarParametros {
		String sesTicket;
		String listName;
		String listExt;
		String listSize;
		String listIdDocumento;
		String idSistema;
		String userOefa;
		String pathAlfresco;
	}

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE)
	class RespuestaSolicitudLinkDescarga {
		String result;
		String downloadUrl;
		AlfrescoStatus status;
		String message;
		String exception;
		String callstack;
		String server;
		String time;
	}
}
