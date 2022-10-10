package oefa.gob.pe.application_services.siee;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.autenticacion.DTOUsuarioRespuesta;
import oefa.gob.pe.application_dto.autenticacion.DTOUsuarioSolicitud;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;
import oefa.gob.pe.infraestructure_data.repository.UsuarioRepository;

@Log4j2
@Component
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
	

    public UsuarioService(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
		
	}
    
    public XsRestServiceResponse<DTOUsuarioRespuesta> listar(DTOUsuarioSolicitud solicitud) {
		XsRestServiceResponse<DTOUsuarioRespuesta> xsRestServiceResponse = new XsRestServiceResponse<>();
		DTOUsuarioRespuesta respuesta = new DTOUsuarioRespuesta();
		try {
			respuesta.dataSource = usuarioRepository.obtenerUsuario(solicitud);
			
			xsRestServiceResponse.setContent(respuesta);
		} catch (Exception ex) {
			xsRestServiceResponse.SetException(ex);
			log.error(ex.getMessage(), ex);
		}
		return xsRestServiceResponse;
	}

	

}
