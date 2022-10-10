package oefa.gob.pe.infraestructure_data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TMapArchivoAlfresco implements Serializable {
    @Serial
    private static final long serialVersionUID = -228785555587052700L;
    private BigDecimal idArchivo;
    private String txNombreArchivo;
    private String txRutaAlfresco;
    private String txUiid;
    private String txNombreArchivoOriginal;
    private String fgSitreg;
    private String audCreadoPor;
    private LocalDateTime audFechaCreacion;
    private String audModificadoPor;
    private LocalDateTime audFechaModificacion;
    private String audEliminadoPor;
    private LocalDateTime audFechaEliminacion;
    private BigDecimal nuFolios;
}