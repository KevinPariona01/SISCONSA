package oefa.gob.pe.application_services.servicios_siged;

import oefa.gob.pe.application_dto.siged.*;
import oefa.gob.pe.infraestructure_cross_cuting.config_properties.Siged;
import org.springframework.stereotype.Component;


@Component
public class SigedRestApp {

	private final String usuarioSiged;

	private final SigedRestService sigedRestService;

	private final String claveSiged;

	private final String urlLoginSiged;

    private final String urlConsultaSiged;

    public SigedRestApp(final SigedRestService sigedRestService, final Siged siged) {
        this.sigedRestService = sigedRestService;
        urlConsultaSiged = siged.getConsulta_url();
        urlLoginSiged = siged.getLogin_url();
        claveSiged = siged.getPassword();
        usuarioSiged = siged.getUser();
    }

    public DTORegistroRespuesta crearRegistroPersonaJuridica(DTOPersonaJuridica persona) {
        return sigedRestService.crearRegistroPersonaJuridica(persona, urlConsultaSiged, sigedRestService.obtenerToken(usuarioSiged, claveSiged, urlLoginSiged).token);
    }

    public DTORegistroRespuesta agregarDocumentoAndArchivo(DTODocumentoCabecera documento) {
        return sigedRestService.agregarDocumentoAndArchivo(documento, urlConsultaSiged, sigedRestService.obtenerToken(usuarioSiged, claveSiged, urlLoginSiged).token);
    }

    public void agregarArchivoAlDocumento(DTODocumento documento) {
        sigedRestService.agregarArchivoAlDocumento(documento, urlConsultaSiged, sigedRestService.obtenerToken(usuarioSiged, claveSiged, urlLoginSiged).token);
    }

    public DTOProcesoCabecera enumerarDocumento(int idDocumento) {
        return sigedRestService.enumerarDocumento(idDocumento, urlConsultaSiged, sigedRestService.obtenerToken(usuarioSiged, claveSiged, urlLoginSiged).token);
    }
}