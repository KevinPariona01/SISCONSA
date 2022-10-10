package oefa.gob.pe.application_dto.siged;

import java.util.List;

public class DTODocumento {
    public String numerodocumento;
    public int tipodocumento;
    public int numerofolios;
    public int esPrincipal;
    public int idDocumento;
    public String asunto;
    public String descripcion;
    public List<DTOArchivo> archivos = null;
    
}
