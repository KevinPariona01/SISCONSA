package oefa.gob.pe.distribuited_services.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oefa.gob.pe.application_dto.jwt.DTOToken;
import oefa.gob.pe.application_dto.sso.DTOSso;
import oefa.gob.pe.application_services.seguridad.JWTAppService;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;

@RestController
@RequestMapping("/siee/api/token")
@CrossOrigin(originPatterns = {"https://*.oefa.gob.pe", "http://localhost:[*]", "http://127.0.0.1:[*]"}, allowedHeaders = "*")
public class CrearTokenController {

	private final JWTAppService jWTAppService;

	public CrearTokenController(final JWTAppService jWTAppService) {
		this.jWTAppService = jWTAppService;
	}

    @PostMapping("/confirmsso2")
	public XsRestServiceResponse<DTOToken> generartoken(@RequestBody DTOSso ssoidem, HttpSession session ) {
		return jWTAppService.generartoken(ssoidem , session);
	}
    
}
