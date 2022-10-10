package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = TMapArchivoAlfresco.ENTITY_NAME)
@Table(name = TMapArchivoAlfresco.TABLE_NAME, schema = "MONITOREO")
public class TMapArchivoAlfresco implements Serializable {
    public static final String ENTITY_NAME = "TMapArchivoAlfresco";
    public static final String TABLE_NAME = "T_MAP_ARCHIVO_ALFRESCO";
    private static final long serialVersionUID = -2963551283147743315L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ARCHIVO", nullable = false)
    private Long id;

    @Column(name = "TX_NOMBRE_ARCHIVO", length = 200)
    private String txNombreArchivo;

    @Column(name = "TX_RUTA_ALFRESCO", length = 200)
    private String txRutaAlfresco;

    @Column(name = "TX_UIID", length = 200)
    private String txUiid;

    @Column(name = "TX_NOMBRE_ARCHIVO_ORIGINAL", length = 200)
    private String txNombreArchivoOriginal;

    @Column(name = "FG_SITREG")
    private Boolean fgSitreg;

    @Column(name = "AUD_CREADO_POR", length = 60)
    private String audCreadoPor;

    @Column(name = "AUD_FECHA_CREACION")
    private LocalDate audFechaCreacion;

    @Column(name = "AUD_MODIFICADO_POR", length = 60)
    private String audModificadoPor;

    @Column(name = "AUD_FECHA_MODIFICACION")
    private LocalDate audFechaModificacion;

    @Column(name = "AUD_ELIMINADO_POR", length = 60)
    private String audEliminadoPor;

    @Column(name = "AUD_FECHA_ELIMINACION")
    private LocalDate audFechaEliminacion;

    @Column(name = "NU_FOLIOS")
    private Long nuFolios;

}