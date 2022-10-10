package oefa.gob.pe.distribuited_services.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.catalogo.DTOCatalogoRespuesta;
import oefa.gob.pe.application_dto.catalogo.DTOCatalogoSolicitud;
import oefa.gob.pe.application_services.siee.CatalogoService;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;


@Log4j2
@RestController
@RequestMapping("/siee/api/catalogo")
@CrossOrigin(originPatterns = {"https://*.oefa.gob.pe", "http://localhost:[*]", "http://127.0.0.1:[*]"}, allowedHeaders = "*")
public class CatalogoController {
    
    private final CatalogoService catalogoServices;

    public CatalogoController(final CatalogoService catalogoServices){
        this.catalogoServices = catalogoServices;
    }

    @PostMapping("/listar")
	public XsRestServiceResponse<DTOCatalogoRespuesta> listar(@RequestBody DTOCatalogoSolicitud solicitud) {
		return catalogoServices.listar(solicitud);
	}

    @PostMapping("/listarPadre")
	public XsRestServiceResponse<DTOCatalogoRespuesta> listarPadre(@RequestBody DTOCatalogoSolicitud solicitud) {
		return catalogoServices.listarPadre(solicitud);
	}

    @PostMapping("/insertar")
    public XsRestServiceResponse<Void> insertar(@RequestBody DTOCatalogoSolicitud solicitud) {
    return catalogoServices.insertar(solicitud);
    }

    @PostMapping("/modificar")
    public XsRestServiceResponse<Void> modificar(@RequestBody DTOCatalogoSolicitud solicitud) {
    return catalogoServices.modificar(solicitud);
    }

    @PostMapping("/eliminar")
    public XsRestServiceResponse<Void> eliminar(@RequestBody DTOCatalogoSolicitud solicitud) {
    return catalogoServices.eliminar(solicitud);
    }

    @PostMapping("/setEstado")
    public XsRestServiceResponse<Void> setEstado(@RequestBody DTOCatalogoSolicitud solicitud) {
    return catalogoServices.setEstado(solicitud);
    }

    @PostMapping("/validar")
	public XsRestServiceResponse<DTOCatalogoRespuesta> validar(@RequestBody DTOCatalogoSolicitud solicitud) {
		return catalogoServices.validar(solicitud);
	}


}

