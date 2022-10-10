package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Entity(name = TMvcDenylistInforme.ENTITY_NAME)
@Table(name = TMvcDenylistInforme.TABLE_NAME, schema = "MONITOREO")
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE MONITOREO.T_MVC_DENYLIST_INFORME SET FE_FECHA_ELI = SYSDATE WHERE id=?", check = ResultCheckStyle.COUNT)
@Where(clause = "FE_FECHA_ELI IS NULL")
public class TMvcDenylistInforme implements Serializable {
    public static final String ENTITY_NAME = "TMvcDenylistInforme";
    public static final String TABLE_NAME = "T_MVC_DENYLIST_INFORME";
    @Serial
    private static final long serialVersionUID = -9041627836961465709L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "RUC", nullable = false, length = 256)
    private String ruc;

    @Column(name = "OBSERVACION", length = 4000)
    private String observacion;

    @Column(name = "TX_USUREG", length = 60)
    @CreatedBy
    private String txUsureg;

    @Column(name = "FE_FECHA_REG")
    @CreatedDate
    private LocalDate feFechaReg;

    @Column(name = "TX_USUMOD", length = 60)
    @LastModifiedBy
    private String txUsumod;

    @Column(name = "FE_FECHA_MOD")
    @LastModifiedDate
    private LocalDate feFechaMod;

    @Column(name = "TX_USUELI", length = 60)
    private String txUsueli;

    @Column(name = "FE_FECHA_ELI")
    private LocalDate feFechaEli;
}