package oefa.gob.pe.application_dto.Parametro;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class DTOParametro implements Serializable {
    @Serial
    private static final long serialVersionUID = -3535242755136004888L;
    public String tipoParametro;
    public String id;
    public String idPadre;
    public String nombre;
    public String nroOrden;
    public String idSigno;
    public int idComponente;
    public String descripcion;
    public int idParametroDet;
    public String idCompIesRedmon;

    public int idInformeEnsayo, idIesRedMonitoreo, idEquipo;
    public String nombrePunto;
    public String componente;
    public boolean checked;

    public String codigoControl;

    public String signoResultado;
    public String valorResultado;
    public String unidadMedidaRes;
}
