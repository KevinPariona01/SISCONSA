package oefa.gob.pe.infraestructure_data.mapper;
import org.apache.ibatis.jdbc.SQL;

import oefa.gob.pe.application_dto.autenticacion.DTOUsuarioSolicitud;

public class UsuarioMapper {

    public String obtenerUsuario(DTOUsuarioSolicitud solicitud) {
        return new SQL() {
            {
                SELECT("TP.NU_ID_PERSONA nuIdPersona");                
                SELECT("TP.NU_ID_PERSONA txCodUsuario");          
                SELECT("TP.TX_ID_TIPO_DOCUMENTO txIdTipoDocumento");          
                SELECT("TP.TX_NUMERO_DOCUMENTO txNumeroDocumento");          
                SELECT("TP.TX_NOMBRES txNombres");          
                SELECT("TP.TX_APELLIDO_PATERNO txApellidoPaterno");          
                SELECT("TP.TX_APELLIDO_MATERNO txApellidoMaterno");          
                SELECT("TP.TX_DIR_CORREO txDirCorreo");          
                SELECT("TP.TX_TLF_MOVIL txTlfMovil");          
                SELECT("TP.TX_ESTADO_REGISTRO txEstadoRegistro");          
                SELECT("TP.TX_ID_USU_REGISTRO txIdUsuRegistro");          
                SELECT("TP.TX_ID_USU_MOD txIdUsuMod");          
                SELECT("TP.TX_ID_USU_ELI txIdUsuEli");          
                SELECT("TP.FE_REGISTRO feRegistro");          
                SELECT("TP.FE_MOD feMod");          
                SELECT("TP.FE_ELI feEli");          
                SELECT("TP.TX_MOTIVO_ELI txMotivoEli");          
                SELECT("TP.TX_IP_REGISTRO txIpRegistro");          
                SELECT("TP.TX_IP_MOD txIpMod");          
                SELECT("TP.TX_IP_ELI txIpEli");          
                SELECT("TP.TX_USUARIO_RED txUsuarioRed");         
                FROM("CORE_EMERGENCIAS.T_MAC_PERSONA TP");
                WHERE("TP.NU_ID_PERSONA =  #{nuIdPersona, jdbcType=INTEGER}");
            }
        }.toString();
    }
}
