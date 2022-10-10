package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;
import oefa.gob.pe.application_dto.Parametro.DTOParametro;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = TMapTipo.ENTITY_NAME)
@Table(name = TMapTipo.TABLE_NAME, schema = "MAESTRO")
@Where(clause = "FG_SITREG = '1'")
public class TMapTipo implements Serializable {
    public static final String ENTITY_NAME = "TMapTipo";
    public static final String TABLE_NAME = "T_MAP_TIPO";

    @Serial
    private static final long serialVersionUID = -2715973125140161688L;
    @Id
    @Column(name = "ID_TIPO", nullable = false)
    private Long id;

    @Column(name = "TX_GRUPO", length = 30)
    private String txGrupo;

    @Column(name = "TX_COD_TIPO", length = 6)
    private String txCodTipo;

    @Column(name = "TX_DESCRIPCION")
    private String txDescripcion;

    @Column(name = "TX_DISCRIMINANTE", length = 1)
    private String txDiscriminante;

    @Column(name = "FG_SITREG")
    private Boolean fgSitreg;

    @Column(name = "TX_USUREG", length = 50)
    private String txUsureg;

    @Column(name = "FE_FECHA_REG")
    private LocalDate feFechaReg;

    @Column(name = "TX_USUMOD", length = 50)
    private String txUsumod;

    @Column(name = "FE_FECHA_MOD")
    private LocalDate feFechaMod;

    @Column(name = "TX_USUELI", length = 50)
    private String txUsueli;

    @Column(name = "FE_FECHA_ELI")
    private LocalDate feFechaEli;

    @Column(name = "TX_DESC_GRUPO", length = 100)
    private String txDescGrupo;

    @Column(name = "TX_COD_TIPO_PADRE", length = 3)
    private String txCodTipoPadre;

    @Column(name = "ORDEN")
    private Long orden;

    public DTOParametro toDTOParametro() {
        var dto = new DTOParametro();
        dto.id = this.txCodTipo;
        dto.nombre = this.txDescripcion;
        dto.nroOrden = this.txGrupo;
        return dto;
    }
}