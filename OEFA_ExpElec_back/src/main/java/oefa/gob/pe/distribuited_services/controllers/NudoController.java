package oefa.gob.pe.distribuited_services.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oefa.gob.pe.application_dto.nudo.DTONudoSolicitud;
import oefa.gob.pe.application_dto.nudo.DTONudosRespuesta;
import oefa.gob.pe.application_services.siee.NudoService;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;

@RestController
@RequestMapping("/siee/api/nudo")
@CrossOrigin(originPatterns = {"https://*.oefa.gob.pe", "http://localhost:[*]", "http://127.0.0.1:[*]"}, allowedHeaders = "*")
public class NudoController {
    
    private final NudoService nudoService;

    public NudoController(final NudoService nudoService){
        this.nudoService = nudoService;
    }

    @PostMapping("/listar")
	public XsRestServiceResponse<DTONudosRespuesta> listar(@RequestBody DTONudoSolicitud solicitud) {
		return nudoService.listar(solicitud);
	}

    @PostMapping("/listarPadre")
	public XsRestServiceResponse<DTONudosRespuesta> listarPadre(@RequestBody DTONudoSolicitud solicitud) {
		return nudoService.listarPadre(solicitud);
	}

    @PostMapping("/listarDepartamentos")
	public XsRestServiceResponse<DTONudosRespuesta> listarDepartamentos(@RequestBody DTONudoSolicitud solicitud) {
		return nudoService.listarDepartamentos(solicitud);
	}

	@PostMapping("/insertarNudoUbigeo")
    public XsRestServiceResponse<Void> insertarNudoUbigeo(@RequestBody DTONudoSolicitud solicitud) {
    	return nudoService.insertarNudoUbigeo(solicitud);
    }

	@PostMapping("/insertarNudo")
    public XsRestServiceResponse<Void> insertarNudo(@RequestBody DTONudoSolicitud solicitud) {
    	return nudoService.insertarNudo(solicitud);
    }

	@PostMapping("/setEstadoNudoUbigeo")
    public XsRestServiceResponse<Void> setEstadoNudoUbigeo(@RequestBody DTONudoSolicitud solicitud) {
    	return nudoService.setEstadoNudoUbigeo(solicitud);
    }

	@PostMapping("/eliminarNudoUbigeo")
    public XsRestServiceResponse<Void> eliminarNudoUbigeo(@RequestBody DTONudoSolicitud solicitud) {
    	return nudoService.eliminarNudoUbigeo(solicitud);
    }

	@PostMapping("/eliminarNudo")
    public XsRestServiceResponse<Void> eliminarNudo(@RequestBody DTONudoSolicitud solicitud) {
    	return nudoService.eliminarNudo(solicitud);
    }

	@PostMapping("/eliminarNudoUbigeoConNudo")
    public XsRestServiceResponse<Void> eliminarNudoUbigeoConNudo(@RequestBody DTONudoSolicitud solicitud) {
    	return nudoService.eliminarNudoUbigeoConNudo(solicitud);
    }

}
