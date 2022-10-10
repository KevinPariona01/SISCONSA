package oefa.gob.pe.application_services.siee;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.documento.DTODocumentoRespuesta;
import oefa.gob.pe.application_dto.documento.DTODocumentoSolicitud;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;
import oefa.gob.pe.infraestructure_data.repository.DocumentoRepository;

@Log4j2
@Component
public class DocumentoService {
    
    private final DocumentoRepository documentoRepository;

    public DocumentoService(final DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public XsRestServiceResponse<DTODocumentoRespuesta> listar(DTODocumentoSolicitud solicitud) {
        XsRestServiceResponse<DTODocumentoRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
        DTODocumentoRespuesta respuesta = new DTODocumentoRespuesta();
        try {
            respuesta.dataSource = documentoRepository.listar(solicitud);
            xsRestServiceResponse.setContent(respuesta);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> insertar(DTODocumentoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            documentoRepository.insertar(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> insertarComentario(DTODocumentoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            documentoRepository.insertarComentario(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

}
