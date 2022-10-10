package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class VwAccionEvaluacionId implements Serializable {
    @Serial
    private static final long serialVersionUID = -3452106311800135686L;
    @Setter(AccessLevel.NONE)
    @Column(name = "IDACCION", nullable = false, precision = 38, scale = 8)
    private BigDecimal idaccion;
    @Setter(AccessLevel.NONE)
    @Column(name = "ID_TIPO_EVAL", nullable = false)
    private Long idTipoEval;
    @Setter(AccessLevel.NONE)
    @Column(name = "ID_AREA_ESTUDIO", nullable = false, precision = 38, scale = 8)
    private BigDecimal idAreaEstudio;
    @Setter(AccessLevel.NONE)
    @Column(name = "ID_UNIDAD_EVALUACION", nullable = false, precision = 38, scale = 8)
    private BigDecimal idUnidadEvaluacion;
    @Setter(AccessLevel.NONE)
    @Column(name = "ID_AREA_EST_UNID_FISC", nullable = false, precision = 38, scale = 8)
    private BigDecimal idAreaEstUnidFisc;

    @Override
    public int hashCode() {
        return Objects.hash(idaccion, idAreaEstUnidFisc, idUnidadEvaluacion, idTipoEval, idAreaEstudio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwAccionEvaluacionId entity = (VwAccionEvaluacionId) o;
        return Objects.equals(this.idaccion, entity.idaccion) &&
                Objects.equals(this.idAreaEstUnidFisc, entity.idAreaEstUnidFisc) &&
                Objects.equals(this.idUnidadEvaluacion, entity.idUnidadEvaluacion) &&
                Objects.equals(this.idTipoEval, entity.idTipoEval) &&
                Objects.equals(this.idAreaEstudio, entity.idAreaEstudio);
    }
}