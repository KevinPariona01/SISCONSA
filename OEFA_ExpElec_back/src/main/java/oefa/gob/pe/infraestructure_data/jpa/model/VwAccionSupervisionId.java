package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class VwAccionSupervisionId implements Serializable {
    private static final long serialVersionUID = -4612481783945858000L;
    @Setter(AccessLevel.NONE)
    @Column(name = "OBJECTID")
    private Long objectid;
    @Setter(AccessLevel.NONE)
    @Column(name = "IDADMINISTRADO", length = 20)
    private String idadministrado;
    @Setter(AccessLevel.NONE)
    @Column(name = "IDUNIDADFISCALIZABLE", length = 30)
    private String idunidadfiscalizable;

    @Override
    public int hashCode() {
        return Objects.hash(idunidadfiscalizable, idadministrado, objectid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwAccionSupervisionId entity = (VwAccionSupervisionId) o;
        return Objects.equals(this.idunidadfiscalizable, entity.idunidadfiscalizable) &&
                Objects.equals(this.idadministrado, entity.idadministrado) &&
                Objects.equals(this.objectid, entity.objectid);
    }
}