package oefa.gob.pe.archivo.application.dto.archivo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class DTOArchivo {
	public Integer idArchivo;
	public String nombreArchivo;
	public String nombreArchivoOriginal;
	public String rutaAlfresto;
	public String uiid;
	public MultipartFile archivo;
	public String tipoArchivo;
	public String tipoDocumento;
	public String descripcion;
	public String urlDescarga;
	public String idTipoTramite;

	public String audCreadoPor;
	public String audModificadoPor;
	public Date audFechaModificacion;
	public Date audFechaCreacion;

	public String opcion;

	// REST API
	public String sesTicket;
	public String listName;
	public String listExt;
	public String listSize;
	public String listIdDocumento;
	public String idSistema;
	public String userOefa;
	public String pathAlfresco;

	public int nroFolios;

	public DTOArchivo() {
		tipoArchivo = "ARCHIVO";
	}
}