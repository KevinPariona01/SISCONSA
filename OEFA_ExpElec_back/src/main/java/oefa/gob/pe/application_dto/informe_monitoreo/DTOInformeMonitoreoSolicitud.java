package oefa.gob.pe.application_dto.informe_monitoreo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Data
public class DTOInformeMonitoreoSolicitud implements Serializable {
    @Serial
    private static final long serialVersionUID = -3433892708466474085L;
    public int idInformeMonitoreo;
    //public int idSubsector;
    public String idSubsector;
    public int idInstrumento;
    public String codigoUfi;
    public String rucAdministrado;
    public String idUfi;
    public String idAdministrado;
    public String nombreInformeMonitoreo;
    public String tipoMonitoreo;
    public String usuario;

    public int idLineaBase;
    public int idPlanMonitoreo;
    public int idCadenaCustodia;
    public int tipo;
    public String filtro;
    public boolean usuarioLector;

    public int idEquipo, idFuente, idInformeEnsayo, idRedMonitoreo;
    public String opcion,origen, codigoObligacion, codigoAccion, tipoModulo;

    public Date StartDate;
    public Date EndDate;
}
