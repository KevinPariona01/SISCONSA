package oefa.gob.pe.application_dto.siged;

import java.util.List;

public class DTODocumentoEnvio {
    public String numerodocumento;
    public int tipodocumento;
    public int numerofolios;
    public int esPrincipal;
    public String asunto;
    public String descripcion;
    public final List<DTOArchivo> archivos = null;
}