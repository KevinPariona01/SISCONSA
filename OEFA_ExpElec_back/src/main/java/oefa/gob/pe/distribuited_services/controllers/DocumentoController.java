package oefa.gob.pe.distribuited_services.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import lombok.extern.log4j.Log4j2;
import oefa.gob.pe.application_dto.documento.DTODocumento;
import oefa.gob.pe.application_dto.documento.DTODocumentoRespuesta;
import oefa.gob.pe.application_dto.documento.DTODocumentoSolicitud;
import oefa.gob.pe.application_services.siee.DocumentoService;
import oefa.gob.pe.infraestructure_cross_cuting.xs_responses.XsRestServiceResponse;

@Log4j2
@RestController
@RequestMapping("/siee/api/documento")
@CrossOrigin(originPatterns = {"https://*.oefa.gob.pe", "http://localhost:[*]", "http://127.0.0.1:[*]"}, allowedHeaders = "*")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(final DocumentoService documentoService){
        this.documentoService = documentoService;
    }

    @PostMapping("/listar")
	public XsRestServiceResponse<DTODocumentoRespuesta> listar(@RequestBody DTODocumentoSolicitud solicitud) {
		return documentoService.listar(solicitud);
	}

    @PostMapping("/insertar")
    public XsRestServiceResponse<Void> insertar(@RequestBody DTODocumentoSolicitud solicitud) {
        return documentoService.insertar(solicitud);
    }
    
    @PostMapping("/insertarComentario")
    public XsRestServiceResponse<Void> insertarComentario(@RequestBody DTODocumentoSolicitud solicitud) {
        return documentoService.insertarComentario(solicitud);
    }

    @PostMapping("/documento")
	public XsRestServiceResponse<String> documento(@RequestBody DTODocumentoSolicitud solicitud) {
        XsRestServiceResponse<String> xsRestServiceResponse = new XsRestServiceResponse<>();
        String documento = "";
        try{
            Document doc = new Document("C:/Users/ADM/Downloads/asdasd.docx");
            documento = doc.toString(SaveFormat.HTML);
            xsRestServiceResponse.setContent(documento);
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return xsRestServiceResponse;     
	}
    
}
