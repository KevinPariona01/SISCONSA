package oefa.gob.pe.application_services.siee;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.catalogo.DTOCatalogoRespuesta;
import oefa.gob.pe.application_dto.catalogo.DTOCatalogoSolicitud;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;
import oefa.gob.pe.infraestructure_data.repository.CatalogoRepository;

@Log4j2
@Component
public class CatalogoService {

    private final CatalogoRepository catalogoRepository;

    public CatalogoService(final CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    public XsRestServiceResponse<DTOCatalogoRespuesta> listar(DTOCatalogoSolicitud solicitud) {
        XsRestServiceResponse<DTOCatalogoRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
        DTOCatalogoRespuesta respuesta = new DTOCatalogoRespuesta();
        try {
            respuesta.dataSource = catalogoRepository.listar(solicitud);
            xsRestServiceResponse.setContent(respuesta);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<DTOCatalogoRespuesta> listarPadre(DTOCatalogoSolicitud solicitud) {
        XsRestServiceResponse<DTOCatalogoRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
        DTOCatalogoRespuesta respuesta = new DTOCatalogoRespuesta();
        try {
            respuesta.dataSource = catalogoRepository.listarPadre(solicitud);
            xsRestServiceResponse.setContent(respuesta);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> insertar(DTOCatalogoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            catalogoRepository.insertar(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> modificar(DTOCatalogoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            catalogoRepository.modificar(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> eliminar(DTOCatalogoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            catalogoRepository.eliminar(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> setEstado(DTOCatalogoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            catalogoRepository.setEstado(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<DTOCatalogoRespuesta> validar(DTOCatalogoSolicitud solicitud) {
        XsRestServiceResponse<DTOCatalogoRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
        DTOCatalogoRespuesta respuesta = new DTOCatalogoRespuesta();
        try {
            respuesta.dataSource = catalogoRepository.validar(solicitud);
            xsRestServiceResponse.setContent(respuesta);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

}
