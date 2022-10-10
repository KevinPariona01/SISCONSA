package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = TMapLineaBase.ENTITY_NAME)
@Table(name = TMapLineaBase.TABLE_NAME, schema = "MONITOREO")
public class TMapLineaBase implements Serializable {
    public static final String ENTITY_NAME = "TMapLineaBase";
    public static final String TABLE_NAME = "T_MAP_LINEA_BASE";
    private static final long serialVersionUID = 5924100365619561098L;
    @Id
    @Column(name = "ID_LINEA_BASE", nullable = false)
    private Long id;

    @Column(name = "TX_NOMBRE", length = 100)
    private String txNombre;

    @Column(name = "FE_FECHA_LB_INICIAL")
    private LocalDate feFechaLbInicial;

    @Column(name = "FE_FECHA_LB_FINAL")
    private LocalDate feFechaLbFinal;

    @Column(name = "FE_FECHA_APROBACION")
    private LocalDate feFechaAprobacion;

    @Column(name = "ID_INSTRUMENTO")
    private Long idInstrumento;

    @Column(name = "FG_SITREG", length = 60)
    private String fgSitreg;

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

    @Column(name = "ID_ARCHIVO")
    private Long idArchivo;

    @Column(name = "TX_ESTADO")
    private Boolean txEstado;

}