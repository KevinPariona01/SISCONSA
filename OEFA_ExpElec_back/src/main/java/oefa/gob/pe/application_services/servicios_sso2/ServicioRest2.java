package oefa.gob.pe.application_services.servicios_sso2;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.sentry.Sentry;
import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.autenticacionSSO.DTO_SSOSolicitud;
import oefa.gob.pe.application_dto.autenticacionSSO.DTO_SSOvalidaUsuario;
import oefa.gob.pe.infraestructure_cross_cuting.common.RestRequestManager;

@Component
@Log4j2
public class ServicioRest2 {

    public DTO_SSOvalidaUsuario obtenerAcceso(DTO_SSOSolicitud solicitud) {
		String content;
		Gson gson = new Gson();
		DTO_SSOvalidaUsuario usuario = new DTO_SSOvalidaUsuario();
		var rest = new JsonObject();
		rest.addProperty("usuario", solicitud.usuario);
		rest.addProperty("clave", solicitud.clave);

		try {
            content = RestRequestManager.postRest("https://desarrollo.oefa.gob.pe/sso2/OefaAdmSeg/login/autenticarInterno", rest.toString(), "U3NvQXBwOmIzYjc0NDM0MWE4NzA5MWFkNTRmZjU4ZDY4OTg5OGFk");
            usuario = gson.fromJson(content, DTO_SSOvalidaUsuario.class);
            /*=====================================TOKEN FORMAT========================= */
            usuario.token = "Bearer Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJPRUZBX0pXVCIsInN1YiI6ImFyb2NhIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSX09FRkEiXSwiaWF0IjoxNjYyNzQyODA4LCJleHAiOjE2NjI3NzE2MDh9.9aKOtdwRzJuvcKg6TECU6adLXQt4C_XpxXW6oysMN5fhWzU0itoFoLmObblsgO_UFeK85SUWRb6zq9mRpMmUwA";
            log.info(usuario.token);
        } catch (IOException | ExecutionException e) {
            log.error("Error al obtener usuario sso2", e);
            Sentry.captureException(e, e.getCause());
        } catch (InterruptedException e) {
            log.error("Error al obtener usuario sso2", e);
            Sentry.captureException(e, e.getCause());
            Thread.currentThread().interrupt();
        }
		return usuario;
	}
}
