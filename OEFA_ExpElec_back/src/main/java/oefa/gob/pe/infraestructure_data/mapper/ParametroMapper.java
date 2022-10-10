package oefa.gob.pe.infraestructure_data.mapper;

import oefa.gob.pe.application_dto.Parametro.DTOParametro;
import org.apache.ibatis.jdbc.SQL;

public class ParametroMapper {

    public String listar(DTOParametro solicitud) {
        return new SQL() {
            {
                SELECT("TX_COD_TIPO id, TX_DESCRIPCION nombre, TX_GRUPO nroOrden FROM MAESTRO.T_MAP_TIPO");

                if (solicitud.tipoParametro.equals("ZONA_SIN_INFORMACION")) {
                    WHERE("TX_DESC_GRUPO = 'ZONA' AND FG_SITREG = '1' AND TX_COD_TIPO <>'100'");
                    ORDER_BY("TX_DESCRIPCION");
                } else {
                    WHERE("TX_DESC_GRUPO = #{tipoParametro, jdbcType=VARCHAR} AND FG_SITREG = '1'");
                    ORDER_BY("TX_DESCRIPCION");
                }
            }
        }.toString();
    }

    public String listarSignoRestringido() {
        return new SQL() {
            {
                SELECT("""
                        TX_COD_TIPO idComponente,  TX_DISCRIMINANTE idSigno  FROM MAESTRO.T_MAP_TIPO
                         WHERE  TX_DESC_GRUPO = 'RESTRICCION_SIGNO' AND FG_SITREG = 1
                        """);
            }
        }.toString();
    }

    public String listarHijo(DTOParametro solicitud) {
        return new SQL() {
            {
                SELECT("TX_COD_TIPO id, TX_DESCRIPCION nombre, TX_GRUPO nroOrden FROM MAESTRO.T_MAP_TIPO");
                WHERE("TX_DESC_GRUPO = #{tipoParametro, jdbcType=VARCHAR}");
                WHERE("TX_COD_TIPO_PADRE = #{idPadre, jdbcType=VARCHAR}");
                ORDER_BY("TX_COD_TIPO ASC");
            }
        }.toString();
    }

    public String correlativoCodigoPunto() {
        return new SQL() {
            {
                SELECT("MONITOREO.SEQ_T_MVC_RED_MON.NEXTVAL FROM DUAL");
            }
        }.toString();
    }

    public String modificarContador(DTOParametro solicitud) {
        return new SQL() {
            {
                UPDATE("MAESTRO.T_MAP_TIPO");
                SET("TX_GRUPO = TX_GRUPO + 1");
                WHERE("TX_DESC_GRUPO = #{tipoParametro, jdbcType=VARCHAR}");
            }
        }.toString();
    }

    public String listarPeriodo(DTOParametro solicitud) {
        return new SQL() {
            {
                SELECT("TX_COD_TIPO id, TX_DESCRIPCION nombre, TX_GRUPO nroOrden FROM MAESTRO.T_MAP_TIPO");
                WHERE("TX_DESC_GRUPO = #{tipoParametro, jdbcType=VARCHAR}");
                WHERE("TX_COD_TIPO = #{id, jdbcType=VARCHAR} AND FG_SITREG = '1'");
                ORDER_BY("TX_DESCRIPCION");
            }
        }.toString();
    }

    public String obtenerIdFrecuenciaReporte(DTOParametro solicitud) {
        return new SQL() {
            {
                SELECT(" CASE WHEN TX_COD_FREC_REPORTE IS NULL THEN '0' ELSE TX_COD_FREC_REPORTE  END id FROM MONITOREO.T_MVD_RED_MON_PAR");
                WHERE("ID_RED_MON_PAR =#{id, jdbcType=INTEGER}");
        }
        }.toString();
    }

    public String obtenerIdFrecuenciaReportePuntoAdicional(DTOParametro solicitud) {
        return new SQL() {
            {
                SELECT(" NVL(TX_COD_FREC_REPORTE,0)  id FROM MONITOREO.T_MVD_RED_MON_COMP_PAR_RESUL");
                WHERE("FG_SITREG = 1 AND ID_RED_MON_COMP_PAR_RESUL =#{idIesRedMonitoreo, jdbcType=INTEGER}");
            }
        }.toString();
    }
}
