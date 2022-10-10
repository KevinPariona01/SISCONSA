package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = VwNombreInforInst.ENTITY_NAME)
@Immutable
@Table(name = VwNombreInforInst.TABLE_NAME, schema = "MONITOREO")
public class VwNombreInforInst implements Serializable {
    public static final String ENTITY_NAME = "VwNombreInforInst";
    public static final String TABLE_NAME = "VW_NOMBRE_INFOR_INST";
    @Serial
    private static final long serialVersionUID = -897969411035878235L;
    @Setter(AccessLevel.NONE)
    @Id
    @Column(name = "ID_INFORME_MONITOREO", nullable = false)
    private Long idInformeMonitoreo;

    @Setter(AccessLevel.NONE)
    @Column(name = "TX_DESCRIPCION", length = 4000)
    private String txDescripcion;

    @Setter(AccessLevel.NONE)
    @Column(name = "TX_TOOLTIP", length = 4000)
    private String txTooltip;

}