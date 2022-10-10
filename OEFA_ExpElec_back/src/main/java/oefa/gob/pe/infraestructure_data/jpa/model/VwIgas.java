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
@Entity(name = VwIgas.ENTITY_NAME)
@Immutable
@Table(name = VwIgas.TABLE_NAME, schema = "MONITOREO")
public class VwIgas implements Serializable {
    public static final String ENTITY_NAME = "VwIgas";
    public static final String TABLE_NAME = "VW_IGAS";
    @Serial
    private static final long serialVersionUID = -1259157484467071041L;
    @EmbeddedId
    private VwIgasId id;

    @Setter(AccessLevel.NONE)
    @Column(name = "OBJECTID")
    private Long objectid;

    @Setter(AccessLevel.NONE)
    @Column(name = "ID_INSTRUMENTO", nullable = false, insertable = false, updatable = false)
    private Long idInstrumento;

    @Setter(AccessLevel.NONE)
    @Column(name = "CODIGO", length = 10)
    private String codigo;

    @Setter(AccessLevel.NONE)
    @Column(name = "ID_TIPO_INSTRUMENTO", insertable = false, updatable = false)
    private Long idTipoInstrumento;

    @Setter(AccessLevel.NONE)
    @Column(name = "TIPO_INSTRUMENTO")
    private String tipoInstrumento;

    @Setter(AccessLevel.NONE)
    @Column(name = "DESCRIPCION", length = 1000)
    private String descripcion;

    @Setter(AccessLevel.NONE)
    @Column(name = "ID_SUBSECTOR", length = 8, insertable = false, updatable = false)
    private String idSubsector;

    @Setter(AccessLevel.NONE)
    @Column(name = "SUBSECTOR", length = 100)
    private String subsector;

    @Setter(AccessLevel.NONE)
    @Column(name = "ID_ADMINISTRADO", length = 20, insertable = false, updatable = false)
    private String idAdministrado;

    @Setter(AccessLevel.NONE)
    @Column(name = "TIPO_DOCUMENTO", length = 150)
    private String tipoDocumento;

    @Setter(AccessLevel.NONE)
    @Column(name = "NRO_DOCUMENTO", length = 15)
    private String nroDocumento;

    @Setter(AccessLevel.NONE)
    @Column(name = "ADMINISTRADO")
    private String administrado;

    @Setter(AccessLevel.NONE)
    @Column(name = "COD_SUR", length = 20)
    private String codSur;

    @Setter(AccessLevel.NONE)
    @Column(name = "COD_UF", length = 30)
    private String codUf;

    @Setter(AccessLevel.NONE)
    @Column(name = "UNIDAD_FISCALIZABLE", length = 500)
    private String unidadFiscalizable;

    @Setter(AccessLevel.NONE)
    @Column(name = "DIRECCION_UF", length = 200)
    private String direccionUf;

    @Setter(AccessLevel.NONE)
    @Column(name = "ESTADO", length = 20)
    private String estado;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXIDNIVEL", length = 100)
    private String txidnivel;

    @Setter(AccessLevel.NONE)
    @Column(name = "TXIDNIVELANT", length = 100)
    private String txidnivelant;

    @Setter(AccessLevel.NONE)
    @Column(name = "FECHA_ESTADO", length = 10)
    private String fechaEstado;

    @Setter(AccessLevel.NONE)
    @Column(name = "FG_TIENE_PLAN_MONITOREO")
    private Boolean fgTienePlanMonitoreo;

}