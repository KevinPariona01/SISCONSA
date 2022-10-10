package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = TMapLaboratorio.ENTITY_NAME)
@Table(name = TMapLaboratorio.TABLE_NAME, schema = "MONITOREO")
public class TMapLaboratorio implements Serializable {
    public static final String ENTITY_NAME = "TMapLaboratorio";
    public static final String TABLE_NAME = "T_MAP_LABORATORIO";
    @Serial
    private static final long serialVersionUID = 417359993115455891L;
    @Id
    @Column(name = "ID_LABORATORIO", nullable = false)
    private Long id;

    @Column(name = "TX_RUC", length = 20)
    private String txRuc;

    @Column(name = "TX_NOMBRE", length = 500)
    private String txNombre;

    @Column(name = "FG_SITREG")
    private Boolean fgSitreg;

    @Column(name = "TX_USUREG", length = 50)
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