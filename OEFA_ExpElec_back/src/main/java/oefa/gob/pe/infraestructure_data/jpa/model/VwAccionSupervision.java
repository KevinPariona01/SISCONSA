package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = VwAccionSupervision.ENTITY_NAME)
@Immutable
@Table(name = VwAccionSupervision.TABLE_NAME, schema = "MONITOREO")
public class VwAccionSupervision implements Serializable {
    public static final String ENTITY_NAME = "VwAccionSupervision";
    public static final String TABLE_NAME = "VW_ACCION_SUPERVISION";
    private static final long serialVersionUID = 3039822679660894562L;
    @EmbeddedId
    private VwAccionSupervisionId id;

    @Setter(AccessLevel.NONE)
    @Column(name = "OBJECTID", insertable = false, updatable = false)
    private Long objectid;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDACCION", nullable = false)
    private Long idaccion;

    @Setter(AccessLevel.NONE)
    @Column(name = "CODIGOACCION", length = 25)
    private String codigoaccion;

    @Setter(AccessLevel.NONE)
    @Column(name = "NUM_EXPEDIENTE", length = 25)
    private String numExpediente;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDADMINISTRADO", length = 20, insertable = false, updatable = false)
    private String idadministrado;

    @Setter(AccessLevel.NONE)
    @Column(name = "TIPO_DOC", length = 150)
    private String tipoDoc;

    @Setter(AccessLevel.NONE)
    @Column(name = "RUC", length = 15)
    private String ruc;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXADMINISTRADO")
    private String txadministrado;

    @Setter(AccessLevel.NONE)
    @Column(name = "COD_SUR", length = 20)
    private String codSur;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDUNIDADFISCALIZABLE", length = 30, insertable = false, updatable = false)
    private String idunidadfiscalizable;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXUNIDADFISCALIZABLE", length = 500)
    private String txunidadfiscalizable;

    @Setter(AccessLevel.NONE)
    @Column(name = "CODSUBSECTOR", length = 8)
    private String codsubsector;

    @Setter(AccessLevel.NONE)
    @Column(name = "DES_SUBSECTOR", length = 100)
    private String desSubsector;

    @Setter(AccessLevel.NONE)
    @Column(name = "TIPO_ACCION", length = 150)
    private String tipoAccion;

    @Setter(AccessLevel.NONE)
    @Column(name = "ESTADO", length = 150)
    private String estado;

    @Setter(AccessLevel.NONE)
    @Column(name = "DESC_TIP_SUP", length = 150)
    private String descTipSup;

    @Setter(AccessLevel.NONE)
    @Column(name = "FECHAINICIO")
    private LocalDate fechainicio;

    @Setter(AccessLevel.NONE)
    @Column(name = "FECHAFIN")
    private LocalDate fechafin;

    @Setter(AccessLevel.NONE)
    @Column(name = "COD_SUPERVISION", length = 10)
    private String codSupervision;

    @Setter(AccessLevel.NONE)
    @Column(name = "UNIDADORGANICA", length = 100)
    private String unidadorganica;

    @Setter(AccessLevel.NONE)
    @Column(name = "COD_UNI_ORGANICA", nullable = false, length = 6)
    private String codUniOrganica;

    @Setter(AccessLevel.NONE)
    @Column(name = "COORDINACION", length = 100)
    private String coordinacion;

    @Setter(AccessLevel.NONE)
    @Column(name = "COD_COORDI", length = 6)
    private String codCoordi;

    @Setter(AccessLevel.NONE)
    @Column(name = "DIRECCION_ADMINISTRADO")
    private String direccionAdministrado;

    @Setter(AccessLevel.NONE)
    @Column(name = "EXPEDIENTE", length = 25)
    private String expediente;

}