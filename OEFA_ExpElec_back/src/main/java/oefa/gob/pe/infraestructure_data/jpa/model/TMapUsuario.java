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
@Entity(name = TMapUsuario.ENTITY_NAME)
@Table(name = TMapUsuario.TABLE_NAME, schema = "MONITOREO")
public class TMapUsuario {
    public static final String ENTITY_NAME = "TMapUsuario";
    public static final String TABLE_NAME = "T_MAC_PERSONA";
    private static final long serialVersionUID = 5924100365619561098L;
    @Id
    @Column(name = "NU_ID_PERSONA", nullable = false)
    private Long nuIdPersona;

    @Column(name = "TX_COD_USUARIO")
    private Long txCodUsuario;

    @Column(name = "TX_ID_TIPO_DOCUMENTO", length = 50)
    private String txIdTipoDocumento;

    @Column(name = "TX_NUMERO_DOCUMENTO", length = 20)
    private String txNumeroDocumento;

    @Column(name = "TX_NOMBRES", length = 100)
    private String txNombres;
    
    @Column(name = "TX_APELLIDO_PATERNO", length = 100)
    private String txApellidoPaterno;

    @Column(name = "TX_APELLIDO_MATERNO", length = 100)
    private String txApellidoMaterno;

    @Column(name = "TX_DIR_CORREO", length = 180)
    private String txDirCorreo;

    @Column(name = "TX_TLF_MOVIL", length = 20)
    private String txTlfMovil;

    @Column(name = "TX_ESTADO_REGISTRO", length = 1)
    private String txEstadoRegistro;

    @Column(name = "TX_ID_USU_REGISTRO", length = 50)
    private String txIdUsuRegistro;

    @Column(name = "TX_ID_USU_MOD", length = 50)
    private String txIdUsuMod;

    @Column(name = "TX_ID_USU_ELI", length = 50)
    private String txIdUsuEli;

    @Column(name = "FE_REGISTRO")
    private LocalDate feRegistro;    

    @Column(name = "FE_MOD")
    private LocalDate feMod;

    @Column(name = "FE_ELI")
    private LocalDate feEli;

    @Column(name = "TX_MOTIVO_ELI", length = 500)
    private String txMotivoEli;

    @Column(name = "TX_IP_REGISTRO", length = 150)
    private String txIpRegistro;

    @Column(name = "TX_IP_MOD", length = 150)
    private String txIpMod;

    @Column(name = "TX_IP_ELI", length = 150)
    private String txIpEli;

    @Column(name = "TX_USUARIO_RED", length = 256)
    private String txUsuarioRed;

}
