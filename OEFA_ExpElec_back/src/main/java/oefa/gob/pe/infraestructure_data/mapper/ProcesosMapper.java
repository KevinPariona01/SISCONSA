package oefa.gob.pe.infraestructure_data.mapper;

import org.apache.ibatis.jdbc.SQL;

import oefa.gob.pe.application_dto.procesos.DTOProcesoSolicitud;

public class ProcesosMapper {

    public String listar(DTOProcesoSolicitud solicitud) {
        return new SQL() {
            {
                SELECT("P.NU_ID_PROCESO idProceso");
                SELECT("P.TX_NOMBRE nombre");
                SELECT("P.TX_ACRONIMO acronimo");
                SELECT("P.TX_DESCRIPCION descripcion");
                SELECT("P.TX_ACTIVO activo");
                SELECT("P.TX_FIRMA firma");
                SELECT("P.TX_REGISTRO_ACTIVO registroActivo");
                SELECT("P.TX_ID_USU_REGISTRA usuRegistra");
                SELECT("P.TX_ID_USU_MODIFICA usuModifica");
                SELECT("P.TX_ID_USU_ELIMINA usuElimina");
                SELECT("P.FE_REGISTRA feRegistra");
                SELECT("P.FE_MODIFICA feModifica");
                SELECT("P.FE_ELIMINA feElimina");
                SELECT("P.TX_IP_REGISTRA ipRegistra");
                SELECT("P.TX_IP_MODIFICA ipModifica");
                SELECT("P.TX_IP_ELIMINA ipElimina");
                SELECT("P.TX_MOTIVO_ELIMINA motivoElimina");
                FROM("CORE_SIEE.T_MAP_PROCESO P");               
		        WHERE("P.TX_REGISTRO_ACTIVO = '1'");
                if(solicitud.activo != ""){
                    WHERE("P.TX_ACTIVO = #{activo, jdbcType=VARCHAR}");
                }

                //WHERE("P.TX_REGISTRO_ACTIVO = '1'");
            }
        }.toString();
    }

    public String editar(DTOProcesoSolicitud solicitud) {
        return new SQL() {
            {
                UPDATE("CORE_SIEE.T_MAP_PROCESO");
                SET("TX_NOMBRE = #{nombre, jdbcType=VARCHAR}");
                SET("TX_ACRONIMO = #{acronimo, jdbcType=VARCHAR}");
                SET("TX_DESCRIPCION = #{descripcion, jdbcType=VARCHAR}");
                SET("TX_FIRMA = #{firma, jdbcType=VARCHAR}");
                SET("FE_MODIFICA = SYSDATE");
                WHERE("NU_ID_PROCESO = #{idProceso, jdbcType=INTEGER}");
            }
        }.toString();
    }

    public String agregar(DTOProcesoSolicitud solicitud) {
        return new SQL() {
            {
                INSERT_INTO("CORE_SIEE.T_MAP_PROCESO");
                VALUES("NU_ID_PROCESO", "t_map_proceso_seq.nextval");
                VALUES("TX_NOMBRE", "#{nombre, jdbcType=VARCHAR}");
                VALUES("TX_ACRONIMO", "#{acronimo, jdbcType=VARCHAR}");
                VALUES("TX_DESCRIPCION", "#{descripcion, jdbcType=VARCHAR}");
                VALUES("TX_ACTIVO", "'1'");
                VALUES("TX_FIRMA", "#{firma, jdbcType=VARCHAR}");
                VALUES("TX_REGISTRO_ACTIVO", "'1'");
                VALUES("FE_REGISTRA", "SYSDATE");
            }
        }.toString();
    }

    public String eliminar(DTOProcesoSolicitud solicitud) {
        return new SQL() {
            {
                UPDATE("CORE_SIEE.T_MAP_PROCESO");
                SET("TX_ACTIVO = '0'");
                SET("TX_REGISTRO_ACTIVO = '0'");
                WHERE("NU_ID_PROCESO = #{idProceso, jdbcType=INTEGER}");
            }
        }.toString();
    }

    public String validar(DTOProcesoSolicitud solicitud) {
        return new SQL() {
            {
                SELECT("P.NU_ID_PROCESO idProceso");
                SELECT("P.TX_NOMBRE nombre");
                SELECT("P.TX_REGISTRO_ACTIVO registroActivo");
                SELECT("P.TX_ACTIVO activo");              
                FROM("CORE_SIEE.T_MAP_PROCESO P");               
		        WHERE("P.TX_ACTIVO = '1'");
                WHERE("P.TX_REGISTRO_ACTIVO = '1'");
                WHERE("TX_NOMBRE = #{nombre, jdbcType=VARCHAR}");
            }
        }.toString();
    }

    public String setEstado(DTOProcesoSolicitud solicitud) {
        return new SQL() {
            {
                UPDATE("CORE_SIEE.T_MAP_PROCESO");
                SET("TX_ACTIVO = #{activo, jdbcType=VARCHAR}");       
                WHERE("NU_ID_PROCESO = #{idProceso, jdbcType=INTEGER}");
            }
        }.toString();
    }

    
}
