package oefa.gob.pe.distribuited_services.controllers;

import oefa.gob.pe.application_dto.Parametro.DTOParametro;
import oefa.gob.pe.application_services.siee.ParametroAppService;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siee/api/parametro")
@CrossOrigin(originPatterns = {"https://*.oefa.gob.pe", "http://localhost:[*]", "http://127.0.0.1:[*]"}, allowedHeaders = "*")
public class ParametroController {

	private final ParametroAppService parametroAppService;

	public ParametroController(final ParametroAppService parametroAppService) {
		this.parametroAppService = parametroAppService;
	}

	@PostMapping("/listar")
	public XsRestServiceResponse<List<DTOParametro>> listar(@RequestBody DTOParametro p) {
		return parametroAppService.listar(p);
	}

	@PostMapping("/listarHijo")
	public XsRestServiceResponse<List<DTOParametro>> listarHijo(@RequestBody DTOParametro p) {
		return parametroAppService.listarHijo(p);
	}
}
