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
public class VwAdminUfSubstId implements Serializable {
    private static final long serialVersionUID = -2299401471712542609L;
    @Setter(AccessLevel.NONE)
    @Column(name = "OBJECTID")
    private Long objectid;
    @Setter(AccessLevel.NONE)
    @Column(name = "IDADM", nullable = false, length = 20)
    private String idadm;
    @Setter(AccessLevel.NONE)
    @Column(name = "IDSECTOR", length = 8)
    private String idsector;
    @Setter(AccessLevel.NONE)
    @Column(name = "IDSUBSECTOR", length = 8)
    private String idsubsector;
    @Setter(AccessLevel.NONE)
    @Column(name = "IDCATEGORIA", length = 20)
    private String idcategoria;
    @Setter(AccessLevel.NONE)
    @Column(name = "IDACTIVIDAD", length = 20)
    private String idactividad;

    @Override
    public int hashCode() {
        return Objects.hash(idsector, idadm, idsubsector, idcategoria, idactividad, objectid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwAdminUfSubstId entity = (VwAdminUfSubstId) o;
        return Objects.equals(this.idsector, entity.idsector) &&
                Objects.equals(this.idadm, entity.idadm) &&
                Objects.equals(this.idsubsector, entity.idsubsector) &&
                Objects.equals(this.idcategoria, entity.idcategoria) &&
                Objects.equals(this.idactividad, entity.idactividad) &&
                Objects.equals(this.objectid, entity.objectid);
    }
}