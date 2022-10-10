package oefa.gob.pe.application_dto.siged;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class DTOHojaTramite {
    public String estado;
    public String status; //Para el caso de que el token no esté activa 403
    public String mensaje;
    public String referencia;
    public String idExpediente;
    public String numero;
    public String titulo;

    // autor
    //proceso

    public Integer plazo;
    public Integer tipoDias;
    public Date fechaCreacion;
    public Time horaCtreacion;

    //trazas
    // expedientes Vinculados
    // carpetas 
    // documentos
    public List<DTODocumento> documentos;

    public String fechaCreacionExpediente;
    public String fechaCreacionTramite;
    public String estadoTramite;
}
