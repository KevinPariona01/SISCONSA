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
@Entity(name = TMvcPlanMonitoreo.ENTITY_NAME)
@Table(name = TMvcPlanMonitoreo.TABLE_NAME)
public class TMvcPlanMonitoreo implements Serializable {
    public static final String ENTITY_NAME = "TMvcPlanMonitoreo";
    public static final String TABLE_NAME = "T_MVC_PLAN_MONITOREO";
    private static final long serialVersionUID = 6123425222412178740L;
    @Id
    @Column(name = "ID_PLAN_MONITOREO", nullable = false)
    private Long id;

    @Column(name = "FG_TIPO_PLAN")
    private Character fgTipoPlan;

    @Column(name = "TX_ESTADO")
    private Boolean txEstado;

    @Column(name = "ID_ACCION")
    private Long idAccion;

    @Column(name = "FG_SITREG")
    private Boolean fgSitreg;

    @Column(name = "TX_USUREG", length = 60)
    private String txUsureg;

    @Column(name = "FE_FECHA_REG")
    private LocalDate feFechaReg;

    @Column(name = "TX_USUMOD", length = 50)
    private String txUsumod;

    @Column(name = "FE_FECHA_MOD")
    private LocalDate feFechaMod;

    @Column(name = "TX_USUELI", length = 50)
    private String txUsueli;

    @Column(name = "FE_FECHA_ELI")
    private LocalDate feFechaEli;

}