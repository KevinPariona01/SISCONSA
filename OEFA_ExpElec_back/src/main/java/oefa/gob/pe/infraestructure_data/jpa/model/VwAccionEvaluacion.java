package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = VwAccionEvaluacion.ENTITY_NAME)
@Immutable
@Table(name = VwAccionEvaluacion.TABLE_NAME, schema = "MAESTRO")
public class VwAccionEvaluacion implements Serializable {
    public static final String ENTITY_NAME = "VwAccionEvaluacion";
    public static final String TABLE_NAME = "VW_ACCION_EVALUACION";
    @Serial
    private static final long serialVersionUID = -5398779766581632162L;
    @EmbeddedId
    private VwAccionEvaluacionId id;

    @Setter(AccessLevel.NONE)
    @Column(name = "IDACCION", nullable = false, precision = 38, scale = 8, updatable = false, insertable = false)
    private BigDecimal idaccion;

    @Setter(AccessLevel.NONE)
    @Column(name = "CODIGOACCION", length = 20)
    private String codigoaccion;

    @Setter(AccessLevel.NONE)
    @Column(name = "FECHAINICIO")
    private Instant fechainicio;

    @Setter(AccessLevel.NONE)
    @Column(name = "FECHAFIN")
    private Instant fechafin;

    @Setter(AccessLevel.NONE)
    @Column(name = "TX_NRO_EXPEDIENTE", length = 50)
    private String txNroExpediente;

    @Setter(AccessLevel.NONE)
    @Column(name = "ID_TIPO_EVAL", nullable = false, updatable = false, insertable = false)
    private Long idTipoEval;

    @Setter(AccessLevel.NONE)
    @Column(name = "TX_TIPO_EVALUACION", length = 120)
    private String txTipoEvaluacion;

    @Setter(AccessLevel.NONE)
    @Column(name = "ID_AREA_ESTUDIO", nullable = false, precision = 38, scale = 8, updatable = false, insertable = false)
    private BigDecimal idAreaEstudio;

    @Setter(AccessLevel.NONE)
    @Column(name = "AREA_ESTUDIO")
    private String areaEstudio;

    @Setter(AccessLevel.NONE)
    @Column(name = "ID_UNIDAD_EVALUACION", nullable = false, precision = 38, scale = 8, updatable = false, insertable = false)
    private BigDecimal idUnidadEvaluacion;

    @Setter(AccessLevel.NONE)
    @Column(name = "UNIDAD_EVALUACION")
    private String unidadEvaluacion;

    @Setter(AccessLevel.NONE)
    @Column(name = "ID_AREA_EST_UNID_FISC", nullable = false, precision = 38, scale = 8, updatable = false, insertable = false)
    private BigDecimal idAreaEstUnidFisc;

    @Setter(AccessLevel.NONE)
    @Column(name = "TX_COD_UF", length = 15)
    private String txCodUf;

}