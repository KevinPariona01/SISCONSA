package oefa.gob.pe.application_services.siee;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.Parametro.DTOParametro;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;
import oefa.gob.pe.infraestructure_data.repository.ParametroRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class ParametroAppService {
	private final ParametroRepository parametroRepository;

	public ParametroAppService(final ParametroRepository parametroRepository) {
		this.parametroRepository = parametroRepository;
	}

	public XsRestServiceResponse<List<DTOParametro>> listar(DTOParametro p) {
		XsRestServiceResponse<List<DTOParametro>> xsRestServiceResponse = new XsRestServiceResponse<>();
		try {
			xsRestServiceResponse.setContent(parametroRepository.listar(p));
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	public XsRestServiceResponse<List<DTOParametro>> listarHijo(DTOParametro solicitud) {
		XsRestServiceResponse<List<DTOParametro>> xsRestServiceResponse = new XsRestServiceResponse<>();
		try {
			xsRestServiceResponse.setContent(parametroRepository.listarHijo(solicitud));
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

}
