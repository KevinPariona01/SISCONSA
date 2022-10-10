package oefa.gob.pe.infraestructure_data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import oefa.gob.pe.application_dto.nudo.DTONudoSolicitud;

@Mapper
public class NudoMapper {
    
    public String listar(DTONudoSolicitud solicitud){
		return new SQL() {
			{
				SELECT("N.NU_ID_NUDO_UBIGEO idNudo");
				SELECT("N.TX_NUDO_NOMBRE nombre");
				SELECT("N.TX_DEPARTAMENTO departamento");
				SELECT("N.TX_ID_UBIGEO ubigeo");
				SELECT("N.TX_ID_UBI_DPTO ubigeoDpto");
				SELECT("N.TX_UBIGEO_ACTIVO activo");
				SELECT("N.NU_ID_NUDO idNudoPadre");
				FROM("CORE_SIEE.TVW_MAP_NUDO_UBIGEO N");  
				WHERE("N.TX_REGISTRO_ACTIVO = '1'");
				if(solicitud.idNudoPadre != 0){
                    WHERE("N.NU_ID_NUDO = #{idNudoPadre, jdbcType=VARCHAR}");
                }
			}
		}.toString();
	}

	public String listarPadre(DTONudoSolicitud solicitud){
		return new SQL() {
			{
				SELECT("N.NU_ID_NUDO idNudo");
				SELECT("N.TX_NUDO_NOMBRE nombre");
				SELECT("N.TX_NUDO_DESCRIPCION descripcion");
				SELECT("N.TX_NUDO_ACTIVO activo");
				FROM("CORE_SIEE.TT_MAC_NUDO N"); 
				WHERE("N.TX_REGISTRO_ACTIVO = '1'");
			}
		}.toString();
	}

	public String listarDepartamentos(DTONudoSolicitud solicitud){
		return new SQL() {
			{
				SELECT("N.TX_ID_UBIGEO ubigeo");
				SELECT("N.TX_ID_UBI_DPTO ubigeoDpto");
				SELECT("N.TX_DEPARTAMENTO departamento");
				FROM("CORE_SIEE.TVW_MAP_DEPARTAMENTOS N");
				//WHERE("N.TX_ESTADO_REGISTRO = '1'");
			}
		}.toString();
	}

	public String insertarNudoUbigeo(DTONudoSolicitud solicitud){
		return new SQL() {
			{
				INSERT_INTO("CORE_SIEE.TT_MVD_NUDO_UBIGEO");
				VALUES("NU_ID_NUDO_UBIGEO","tt_mvd_nudo_ubigeo_seq.nextval");
				VALUES("NU_ID_NUDO","#{idNudo, jdbcType=INTEGER}");
				VALUES("TX_ID_UBIGEO","#{ubigeo, jdbcType=INTEGER}");
				VALUES("TX_ID_UBI_DPTO","#{ubigeoDpto, jdbcType=VARCHAR}");
				VALUES("TX_DEPARTAMENTO","#{departamento, jdbcType=VARCHAR}");
			}
		}.toString();
	}

	public String insertarNudo(DTONudoSolicitud solicitud){
		return new SQL() {
			{
				INSERT_INTO("CORE_SIEE.TT_MAC_NUDO");
				VALUES("NU_ID_NUDO","tt_map_nudo_seq.nextval");
				VALUES("TX_NUDO_NOMBRE","#{nombre, jdbcType=INTEGER}");
				VALUES("TX_NUDO_DESCRIPCION","#{descripcion, jdbcType=VARCHAR}");
			}
		}.toString();
	}

	public String setEstadoNudoUbigeo(DTONudoSolicitud solicitud) {
		return new SQL() {
			{
				UPDATE("CORE_SIEE.TT_MVD_NUDO_UBIGEO");
                SET("TX_UBIGEO_ACTIVO = #{activo, jdbcType=VARCHAR}");       
                WHERE("NU_ID_NUDO_UBIGEO = #{idNudo, jdbcType=INTEGER}");
			}
		}.toString();
	}

	public String eliminarNudoUbigeo(DTONudoSolicitud solicitud) {
		return new SQL() {
			{
				UPDATE("CORE_SIEE.TT_MVD_NUDO_UBIGEO");
                SET("TX_REGISTRO_ACTIVO = #{regisActivo, jdbcType=VARCHAR}");       
                WHERE("NU_ID_NUDO_UBIGEO = #{idNudo, jdbcType=INTEGER}");
			}
		}.toString();
	}

	public String eliminarNudo(DTONudoSolicitud solicitud) {
		return new SQL() {
			{
				UPDATE("CORE_SIEE.TT_MAC_NUDO");
                SET("TX_REGISTRO_ACTIVO = #{regisActivo, jdbcType=VARCHAR}");       
                WHERE("NU_ID_NUDO = #{idNudo, jdbcType=INTEGER}");
			}
		}.toString();
	}

	public String eliminarNudoUbigeoConNudo(DTONudoSolicitud solicitud) {
		return new SQL() {
			{
				UPDATE("CORE_SIEE.TT_MVD_NUDO_UBIGEO");
                SET("TX_REGISTRO_ACTIVO = #{regisActivo, jdbcType=VARCHAR}");       
                WHERE("NU_ID_NUDO = #{idNudo, jdbcType=INTEGER}");
			}
		}.toString();
	}

}
