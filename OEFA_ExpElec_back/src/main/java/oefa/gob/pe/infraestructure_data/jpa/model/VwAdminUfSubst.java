package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = VwAdminUfSubst.ENTITY_NAME)
@Immutable
@Table(name = VwAdminUfSubst.TABLE_NAME, schema = "MONITOREO")
public class VwAdminUfSubst implements Serializable {
    public static final String ENTITY_NAME = "VwAdminUfSubst";
    public static final String TABLE_NAME = "VW_ADMIN_UF_SUBST";
    @Serial
    private static final long serialVersionUID = 9165112978414349671L;
    @EmbeddedId
    private VwAdminUfSubstId id;

    @Setter(AccessLevel.NONE)
    @Column(name = "OBJECTID", insertable = false, updatable = false)
    private Long objectid;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDADM", nullable = false, length = 20, insertable = false, updatable = false)
    private String idadm;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXTIPODOC", length = 150)
    private String txtipodoc;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXNUMDOC", length = 15)
    private String txnumdoc;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXADM")
    private String txadm;

    @Setter(AccessLevel.NONE)
    @Column(name = "COD_SUR", nullable = false, length = 20)
    private String codSur;

    @Setter(AccessLevel.NONE)
    @Column(name = "COD_UF", length = 30)
    private String codUf;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXUF", length = 500)
    private String txuf;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDSECTOR", length = 8, insertable = false, updatable = false)
    private String idsector;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXSECTOR", length = 100)
    private String txsector;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDSUBSECTOR", length = 8, insertable = false, updatable = false)
    private String idsubsector;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXSUBSECTOR", length = 100)
    private String txsubsector;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDCATEGORIA", length = 20, insertable = false, updatable = false)
    private String idcategoria;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXCATEGORIA")
    private String txcategoria;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDACTIVIDAD", length = 20, insertable = false, updatable = false)
    private String idactividad;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXACTIVIDAD", length = 350)
    private String txactividad;
}