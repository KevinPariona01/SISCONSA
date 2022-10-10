package oefa.gob.pe.distribuited_services.controllers;

import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.autenticacion.DTOUsuarioRespuesta;
import oefa.gob.pe.application_dto.autenticacion.DTOUsuarioSolicitud;
import oefa.gob.pe.application_dto.autenticacionSSO.DTO_SSOSolicitud;
import oefa.gob.pe.application_dto.autenticacionSSO.DTO_SSOvalidaUsuario;
import oefa.gob.pe.application_services.servicios_sso2.ServicioRest2;
import oefa.gob.pe.application_services.siee.UsuarioService;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;

@RestController
@RequestMapping("/siee/api/usuario")
@CrossOrigin(originPatterns = {"https://*.oefa.gob.pe", "http://localhost:[*]", "http://127.0.0.1:[*]"}, allowedHeaders = "*")
@Log4j2
public class UsuarioController {
    
    private final UsuarioService  usuarioService;
    private final ServicioRest2 servicioRest;

    public UsuarioController(final UsuarioService usuarioService, final ServicioRest2 servicioRest){
        this.usuarioService = usuarioService;
        this.servicioRest = servicioRest;
    }

    @GetMapping("/saludar")
	public String saludar() {
		return getClass().getSimpleName() + " ejecutando correctamente.";
	}

    @PostMapping("/listar")
    public XsRestServiceResponse<DTOUsuarioRespuesta> listar(@RequestBody DTOUsuarioSolicitud solicitud) {
        return usuarioService.listar(solicitud);
    }

    @PostMapping("/login")
	public DTO_SSOvalidaUsuario obtenerAcceso(@RequestBody DTO_SSOSolicitud solicitud) {
		DTO_SSOvalidaUsuario p = null;
		try {
			p = servicioRest.obtenerAcceso(solicitud);
		} catch (Exception e) {
			log.error(e);
		}
		return p;
	}
}
