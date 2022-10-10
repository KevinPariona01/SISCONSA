package oefa.gob.pe.application_services.seguridad;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.informe_monitoreo.DTOArchivoMpv;
import oefa.gob.pe.application_dto.informe_monitoreo.DTOInformeMonitoreo;
import oefa.gob.pe.application_dto.jwt.DTOToken;
import oefa.gob.pe.application_dto.sso.DTOSso;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

@Log4j2
@Component
public class JWTAppService {

	public XsRestServiceResponse<DTOToken> generartoken(DTOSso solicitud , HttpSession session ) {
		XsRestServiceResponse<DTOToken> xsRestServiceResponse = new XsRestServiceResponse<>();
		try {
			session.setAttribute("token", solicitud.getToken());
			String username = solicitud.geteIdUsuario();
			String codeUsuario = solicitud.getuCodUsuario();

			DTOToken dtoToken = new DTOToken();
			String token = getJWTToken(username, codeUsuario );
			dtoToken.setValido(true);
			dtoToken.setData(null);
			dtoToken.setMensaje(token);

			xsRestServiceResponse.setContent(dtoToken);
		}catch(Exception ex){
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	private String getJWTToken(String username, String codeUsuario ) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER_XS");
		log.info(username);
		String token = Jwts.builder()
		                   .setId("XS_CORP_JWT")
		                   .setSubject(username)
		                   .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
		                   .setIssuedAt(new Date(System.currentTimeMillis()))
		                   .setExpiration(new Date(System.currentTimeMillis() + setXsExpiration(8, "HOURS")))
		                   .signWith(SignatureAlgorithm.HS512, JWTConstants.SECRET.getBytes())
		                   .compact();

		return JWTConstants.PREFIX + token;
	}

	public String obtenerKotenMpv(DTOInformeMonitoreo informe, String key, String url, List<DTOArchivoMpv> archivos) {
		String tipoDoc = "DNI";
		if(informe.rucAdministrado.length()==11) tipoDoc= "RUC";
		
		return url + Jwts.builder()
		                   .setId("XS_CORP_JWT")
		                   .setSubject(informe.usuario)
		                   .setIssuer("https://www.oefa.gob.pe/")
						   .claim("tipoIdentificacion", tipoDoc)
						//    .claim("tokenSso", informe.tokenSso)
						//    .claim("idUsuario", informe.idUsuarioLogin)
						   .claim("nroIdentificacion", informe.rucAdministrado)
						   .claim("idInformeMonitoreo", informe.idInformeMonitoreo)
						   .claim("nombreInformeMonitoreo", informe.nombreInformeMonitoreo)
						//    .claim("idSubsector", informe.idSubsector)
						//    .claim("codigoUfi", informe.codigoUfi)
						   .claim("unidadFiscalizable", informe.unidadFiscalizable)
						//    .claim("fechaInicial", informe.fechaInicialText)
						//    .claim("fechaFinal", informe.fechaFinalText)
						//    .claim("fechaPresentacion", informe.fechaPresentacionText)
						   .claim("nombreAdministrado", informe.nombreAdministrado)
						//    .claim("etapa", informe.txEtapa)
						//    .claim("frecuenciaReporte", informe.txFrecuenciaReporte)
						//    .claim("periodo", informe.txPeriodo)
						//    .claim("nombreIga", informe.nombreInstrumento)
						   .claim("correo", informe.correo)
						   .claim("archivos", archivos)
		                   .setIssuedAt(new Date(System.currentTimeMillis()))
		                   .setExpiration(new Date(System.currentTimeMillis() + this.setXsExpiration(6, "HOURS")))
		                   .signWith(SignatureAlgorithm.HS512, key.getBytes())
		                   .compact();
	}

	private int setXsExpiration(int number, String format) {
		String formatTime = format;
		int valueBase = 60000;
		if (number == 0)
			formatTime = "DEFAULT";
		int millis = switch (formatTime) {
			case "MINUTES" -> number * valueBase;
			case "HOURS" -> (60 * number) * valueBase;
			case "DAYS" -> ((60 * 24) * number) * valueBase;
			default -> 60 * valueBase;
		};
		return millis;
	}
}