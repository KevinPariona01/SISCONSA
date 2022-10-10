package oefa.gob.pe.application_services.siee;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.nudo.DTONudoSolicitud;
import oefa.gob.pe.application_dto.nudo.DTONudosRespuesta;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;
import oefa.gob.pe.infraestructure_data.repository.NudoRepository;

@Log4j2
@Component
public class NudoService {
    
    private final NudoRepository nudoRepository;

    public NudoService(final NudoRepository nudoRepository) {
        this.nudoRepository = nudoRepository;
    }

    public XsRestServiceResponse<DTONudosRespuesta> listar(DTONudoSolicitud solicitud){
        XsRestServiceResponse<DTONudosRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
        DTONudosRespuesta respuesta = new DTONudosRespuesta();
        try {
            respuesta.dataSource = nudoRepository.listar(solicitud);
            xsRestServiceResponse.setContent(respuesta);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<DTONudosRespuesta> listarPadre(DTONudoSolicitud solicitud){
        XsRestServiceResponse<DTONudosRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
        DTONudosRespuesta respuesta = new DTONudosRespuesta();
        try {
            respuesta.dataSource = nudoRepository.listarPadre(solicitud);
            xsRestServiceResponse.setContent(respuesta);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<DTONudosRespuesta> listarDepartamentos(DTONudoSolicitud solicitud){
        XsRestServiceResponse<DTONudosRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
        DTONudosRespuesta respuesta = new DTONudosRespuesta();
        try {
            respuesta.dataSource = nudoRepository.listarDepartamentos(solicitud);
            xsRestServiceResponse.setContent(respuesta);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> insertarNudoUbigeo(DTONudoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            nudoRepository.insertarNudoUbigeo(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> insertarNudo(DTONudoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            nudoRepository.insertarNudo(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> setEstadoNudoUbigeo(DTONudoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            nudoRepository.setEstadoNudoUbigeo(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> eliminarNudoUbigeo(DTONudoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            nudoRepository.eliminarNudoUbigeo(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> eliminarNudo(DTONudoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            nudoRepository.eliminarNudo(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }

    public XsRestServiceResponse<Void> eliminarNudoUbigeoConNudo(DTONudoSolicitud solicitud) {
        XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
        try {
            nudoRepository.eliminarNudoUbigeoConNudo(solicitud);
        } catch (Exception ex) {
            xsRestServiceResponse.SetException(ex);
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;
    }
    
}
