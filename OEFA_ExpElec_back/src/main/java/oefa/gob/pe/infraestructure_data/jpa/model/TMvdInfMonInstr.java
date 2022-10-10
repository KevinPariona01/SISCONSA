package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import org.hibernate.annotations.Where;

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
@Entity(name = TMvdInfMonInstr.ENTITY_NAME)
@Table(name = TMvdInfMonInstr.TABLE_NAME, schema = "MONITOREO", indexes = {
        @Index(name = "IDX_INF_MON_INSTR_FG_SITREG", columnList = "FG_SITREG")
})
@Where(clause = "FG_SITREG = '1'")
public class TMvdInfMonInstr implements Serializable {
    public static final String ENTITY_NAME = "TMvdInfMonInstr";
    public static final String TABLE_NAME = "T_MVD_INF_MON_INSTR";
    @Serial
    private static final long serialVersionUID = 6453864932579655582L;
    @Id
    @Column(name = "ID_INF_MON_INSTR", nullable = false)
    private Long id;

    @Column(name = "ID_INFORME_MONITOREO", nullable = false)
    private Long idInformeMonitoreo;

    @Column(name = "ID_INSTRUMENTO", nullable = false)
    private Long idInstrumento;

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

}