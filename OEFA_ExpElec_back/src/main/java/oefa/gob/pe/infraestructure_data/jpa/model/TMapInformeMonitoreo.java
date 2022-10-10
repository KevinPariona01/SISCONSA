package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = TMapInformeMonitoreo.ENTITY_NAME)
@Table(name = TMapInformeMonitoreo.TABLE_NAME, schema = "MONITOREO", indexes = {
        @Index(name = "IDX_INFORME_MONITOREO_FG_SITREG", columnList = "FG_SITREG"),
        @Index(name = "IDX_INFORME_MONITOREO_FG_SITREG_RUC_ADMINISTRADO", columnList = "TX_RUC_ADMINISTRADO, FG_SITREG"),
        @Index(name = "IDX_INFORME_MONITOREO_ID_INSTRUMENTO", columnList = "ID_INSTRUMENTO")
})
public class TMapInformeMonitoreo implements Serializable {
    public static final String ENTITY_NAME = "TMapInformeMonitoreo";
    public static final String TABLE_NAME = "T_MAP_INFORME_MONITOREO";
    @Serial
    private static final long serialVersionUID = -8733016084985272100L;
    @Id
    @Column(name = "ID_INFORME_MONITOREO", nullable = false)
    private Long id;

    @Column(name = "TX_NOMBRE", length = 250)
    private String txNombre;

    @Column(name = "COD_SUBSECTOR", length = 20)
    private String codSubsector;

    @Column(name = "TX_COD_UNIDAD_FISCALIZABLE", length = 16)
    private String txCodUnidadFiscalizable;

    @Column(name = "TX_RUC_ADMINISTRADO", length = 16)
    private String txRucAdministrado;

    @Column(name = "FE_FECHA_PRESENTACION")
    private LocalDate feFechaPresentacion;

    @Column(name = "FG_SITREG")
    private Boolean fgSitreg;

    @Column(name = "TX_USUREG", length = 60)
    private String txUsureg;

    @Column(name = "FE_FECHA_REG")
    private LocalDate feFechaReg;

    @Column(name = "TX_USUMOD", length = 60)
    private String txUsumod;

    @Column(name = "FE_FECHA_MOD")
    private LocalDate feFechaMod;

    @Column(name = "TX_USUELI", length = 60)
    private String txUsueli;

    @Column(name = "FE_FECHA_ELI")
    private LocalDate feFechaEli;

    @Column(name = "ID_INSTRUMENTO")
    private Long idInstrumento;

    @Column(name = "ID_ETAPA")
    private Long idEtapa;

    @Column(name = "ID_FREC_REPORTE")
    private Long idFrecReporte;

    @Column(name = "ID_PERIODO", length = 120)
    private String idPeriodo;

    @Column(name = "FG_ESTADO")
    private Boolean fgEstado;

    @Column(name = "ID_EXPEDIENTE")
    private Long idExpediente;

    @Column(name = "TX_COD_EXPEDIENTE", length = 50)
    private String txCodExpediente;

}