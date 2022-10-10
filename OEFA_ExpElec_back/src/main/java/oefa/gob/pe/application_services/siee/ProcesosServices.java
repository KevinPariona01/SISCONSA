package oefa.gob.pe.application_services.siee;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.procesos.DTOProcesoSolicitud;
import oefa.gob.pe.application_dto.procesos.DTOProcesosRespuesta;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;
import oefa.gob.pe.infraestructure_data.repository.ProcesosRepository;

@Log4j2
@Component
public class ProcesosServices {
    private final ProcesosRepository procesosRepository;

    public ProcesosServices(final ProcesosRepository procesosRepository) {
		this.procesosRepository = procesosRepository;

	}

    public XsRestServiceResponse<DTOProcesosRespuesta> listar(DTOProcesoSolicitud solicitud) {
		XsRestServiceResponse<DTOProcesosRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
		DTOProcesosRespuesta respuesta = new DTOProcesosRespuesta();
		try {
			respuesta.dataSource = procesosRepository.listar(solicitud);
			xsRestServiceResponse.setContent(respuesta);
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	public XsRestServiceResponse<Void> agregar(DTOProcesoSolicitud solicitud) {
		XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
		try {
			procesosRepository.agregar(solicitud);
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	public XsRestServiceResponse<Void> editar(DTOProcesoSolicitud solicitud) {
		XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
		try {
			procesosRepository.editar(solicitud);
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	public XsRestServiceResponse<Void> eliminar(DTOProcesoSolicitud solicitud) {
		XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
		try {
			procesosRepository.eliminar(solicitud);
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	public XsRestServiceResponse<DTOProcesosRespuesta> validar(DTOProcesoSolicitud solicitud) {
		XsRestServiceResponse<DTOProcesosRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
		DTOProcesosRespuesta respuesta = new DTOProcesosRespuesta();
		try {
			respuesta.dataSource = procesosRepository.validar(solicitud);
			xsRestServiceResponse.setContent(respuesta);
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	public XsRestServiceResponse<Void> setEstado(DTOProcesoSolicitud solicitud) {
		XsRestServiceResponse<Void> xsRestServiceResponse = new XsRestServiceResponse<>();
		try {
			procesosRepository.setEstado(solicitud);
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	

}
