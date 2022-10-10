package oefa.gob.pe.application_services.siee;

import com.google.gson.Gson;
import io.sentry.protocol.User;
import io.sentry.spring.SentryUserProvider;
import lombok.NonNull;
import oefa.gob.pe.application_dto.jwt.DTOUser;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Component
class CustomSentryUserProvider implements SentryUserProvider {
	private static final Gson gson = new Gson();
	private static final Base64.Decoder decoder = Base64.getDecoder();

	public User provideUser() {
		final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		final ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		assert servletRequestAttributes != null;
		final HttpServletRequest request = servletRequestAttributes.getRequest();
		final User user = new User();
		user.setIpAddress(toIpAddress(request));
		user.setUsername(toName(request));
		return user;
	}

	private static String toName(@NonNull HttpServletRequest request) {
		String Jwt = request.getHeader("Authorization");
		if (Jwt == null) {
			return "No Autenticado";
		}
		String[] chunks = Jwt.split("\\.");
		if (chunks.length != 3) {
			return "Error_jwt__" + Jwt;
		}
		String payload = chunks[1];
		DTOUser respuesta = gson.fromJson(new String(decoder.decode(chunks[1])), DTOUser.class);
		return respuesta.sub;
	}

	private static String toIpAddress(@NonNull HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress != null) {
			return ipAddress.contains(",") ? ipAddress.split(",")[0].trim() : ipAddress;
		} else {
			return request.getRemoteAddr();
		}
	}
}