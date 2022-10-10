package oefa.gob.pe.distribuited_services.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oefa.gob.pe.application_dto.procesos.DTOProcesoSolicitud;
import oefa.gob.pe.application_dto.procesos.DTOProcesosRespuesta;
import oefa.gob.pe.application_services.siee.ProcesosServices;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;

@RestController
@RequestMapping("/siee/api/proceso")
@CrossOrigin(originPatterns = {"https://*.oefa.gob.pe", "http://localhost:[*]", "http://127.0.0.1:[*]"}, allowedHeaders = "*")
public class ProcesosController {
    private final ProcesosServices procesosServices;

    public ProcesosController(final ProcesosServices procesosServices) {
		this.procesosServices = procesosServices;
	}

    @PostMapping("/listar")
	public XsRestServiceResponse<DTOProcesosRespuesta> listar(@RequestBody DTOProcesoSolicitud solicitud) {
		return procesosServices.listar(solicitud);
	}

	@PostMapping("/agregar")
	public XsRestServiceResponse<Void> agregar(@RequestBody DTOProcesoSolicitud solicitud) {
		return procesosServices.agregar(solicitud);
	}

	@PostMapping("/editar")
	public XsRestServiceResponse<Void> editar(@RequestBody DTOProcesoSolicitud solicitud) {
		return procesosServices.editar(solicitud);
	}

	@PostMapping("/eliminar")
	public XsRestServiceResponse<Void> eliminar(@RequestBody DTOProcesoSolicitud solicitud) {
		return procesosServices.eliminar(solicitud);
	}
    
	@PostMapping("/validar")
	public XsRestServiceResponse<DTOProcesosRespuesta> validar(@RequestBody DTOProcesoSolicitud solicitud) {
		return procesosServices.validar(solicitud);
	}

	@PostMapping("/setEstado")
	public XsRestServiceResponse<Void> setEstado(@RequestBody DTOProcesoSolicitud solicitud) {
		return procesosServices.setEstado(solicitud);
	}
	
}
