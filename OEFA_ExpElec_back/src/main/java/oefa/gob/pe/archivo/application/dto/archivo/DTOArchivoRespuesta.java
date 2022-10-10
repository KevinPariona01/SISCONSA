package oefa.gob.pe.archivo.application.dto.archivo;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class DTOArchivoRespuesta {
	public Integer idArchivo;
	public Boolean estado;
	public String mensaje;
	public DTOArchivo archivo;

	// Nuevo
	public String ticketAlfresco;
	public String urlIframe;
	public String archivoHtml;
	public String keyAlfres;
	public String keySesion;
	public String keyh;

	public String urlDownload;
	public String fullUrlDownload;
	public String formActionURL;
}