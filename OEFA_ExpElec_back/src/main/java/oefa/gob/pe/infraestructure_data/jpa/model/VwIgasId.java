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
public class VwIgasId implements Serializable {
    private static final long serialVersionUID = -2906519998045300362L;
    @Setter(AccessLevel.NONE)
    @Column(name = "ID_INSTRUMENTO", nullable = false, insertable = false, updatable = false)
    private Long idInstrumento;
    @Setter(AccessLevel.NONE)
    @Column(name = "ID_TIPO_INSTRUMENTO", insertable = false, updatable = false)
    private Long idTipoInstrumento;
    @Setter(AccessLevel.NONE)
    @Column(name = "ID_SUBSECTOR", length = 8, insertable = false, updatable = false)
    private String idSubsector;
    @Setter(AccessLevel.NONE)
    @Column(name = "ID_ADMINISTRADO", length = 20, insertable = false, updatable = false)
    private String idAdministrado;

    @Override
    public int hashCode() {
        return Objects.hash(idAdministrado, idInstrumento, idTipoInstrumento, idSubsector);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VwIgasId entity = (VwIgasId) o;
        return Objects.equals(this.idAdministrado, entity.idAdministrado) &&
                Objects.equals(this.idInstrumento, entity.idInstrumento) &&
                Objects.equals(this.idTipoInstrumento, entity.idTipoInstrumento) &&
                Objects.equals(this.idSubsector, entity.idSubsector);
    }
}