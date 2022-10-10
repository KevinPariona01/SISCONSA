package oefa.gob.pe.infraestructure_data.jpa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = TMvcCadenaCustodia.ENTITY_NAME)
@Table(name = TMvcCadenaCustodia.TABLE_NAME, schema = "MONITOREO")
public class TMvcCadenaCustodia implements Serializable {
    public static final String ENTITY_NAME = "TMvcCadenaCustodia";
    public static final String TABLE_NAME = "T_MVC_CADENA_CUSTODIA";
    private static final long serialVersionUID = 5096035758419928117L;
    @Id
    @Column(name = "ID_CADENA_CUSTODIA")
    private Long idCadenaCustodia;

    @Column(name = "NUM_DNI")
    private Long numDni;

    @Column(name = "TXT_DATOS_PERSONA", length = 200)
    private String txtDatosPersona;

    @Column(name = "NUM_TELEFONO")
    private Long numTelefono;

    @Column(name = "FECHA_ENVIO_MUESTRA")
    private LocalDate fechaEnvioMuestra;

    @Column(name = "HORA_RECEPCION_MUESTRA", length = 60)
    private String horaRecepcionMuestra;

    @Column(name = "ID_LABORATORIO")
    private Long idLaboratorio;

    @Column(name = "ID_PLAN_MONITOREO")
    private Long idPlanMonitoreo;

    @Column(name = "FG_SITREG", length = 60)
    private String fgSitreg;

    @Column(name = "TX_USUREG", length = 60)
    private String txUsureg;

    @Column(name = "FE_FECHA_REG")
    private LocalDate feFechaReg;

    @Column(name = "TX_USUMOD", length = 60)
    private String txUsumod;

    @Column(name = "FE_FECHA_MOD")
    private LocalDate feFechaMod;

    @Column(name = "TX_USUELI", length = 60)
    private String txUsueli;

    @Column(name = "FE_FECHA_ELI")
    private LocalDate feFechaEli;

    @Column(name = "FECHA_RECEPCION_MUESTRA")
    private LocalDate fechaRecepcionMuestra;

    @Column(name = "TXT_RESULTADO", length = 10)
    private String txtResultado;

    @Column(name = "TXT_OBSERVACION", length = 500)
    private String txtObservacion;

    @Column(name = "FG_ESTADO_REGISTRO")
    private Boolean fgEstadoRegistro;

    @Column(name = "ID_ARCHIVO")
    private Long idArchivo;

    @Column(name = "NUM_DNI_SEC")
    private Long numDniSec;

    @Column(name = "NUM_TELEFONO_SEC")
    private Long numTelefonoSec;

    @Column(name = "TXT_DATOS_PERSONA_SEC", length = 200)
    private String txtDatosPersonaSec;

    @Column(name = "TX_CORREO", length = 100)
    private String txCorreo;

    @Column(name = "TX_CORREO_SEC", length = 200)
    private String txCorreoSec;

    @Column(name = "ORIGEN_REGISTRO", length = 10)
    private String origenRegistro;

    @Column(name = "ID_TDR")
    private Long idTdr;

}