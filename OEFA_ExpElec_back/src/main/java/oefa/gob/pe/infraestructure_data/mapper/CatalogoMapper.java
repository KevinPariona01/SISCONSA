package oefa.gob.pe.infraestructure_data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import oefa.gob.pe.application_dto.catalogo.DTOCatalogoSolicitud;


@Mapper
public class CatalogoMapper {
    
    public String listar(DTOCatalogoSolicitud solicitud) {
		return new SQL() {
			{
				SELECT("C.NU_ID_ITEM idItem");
				SELECT("C.NU_ID_CATALOGO idCatalogo");
				SELECT("C.TX_ITEM_VALOR valor");
				SELECT("C.TX_ITEM_ETIQUETA etiqueta");
				SELECT("C.TX_ITEM_DESCRIPCION descripcion");
				SELECT("C.TX_ITEM_ACTIVO activo");
				FROM("CORE_SIEE.TT_MAP_CATALOGO C");
				WHERE("C.TX_REGISTRO_ACTIVO = '1'");
				//WHERE("C.NU_ID_CATALOGO <> '0'");
				if(solicitud.idCatalogo != 0){
                    WHERE("C.NU_ID_CATALOGO = #{idCatalogo, jdbcType=VARCHAR}");
                }
			}
		}.toString();
	}

	public String listarPadre(DTOCatalogoSolicitud solicitud) {
		return new SQL() {
			{
				SELECT("C.NU_ID_ITEM idItem");
				SELECT("C.TX_ITEM_VALOR valor");
				FROM("CORE_SIEE.TT_MAP_CATALOGO C");
				WHERE("C.TX_ITEM_ACTIVO = '1'");
				WHERE("C.TX_REGISTRO_ACTIVO = '1'");
				WHERE("C.NU_ID_CATALOGO = '0'");
			}
		}.toString();
	}

    public String insertar(DTOCatalogoSolicitud solicitud) {
		return new SQL() {
			{
				INSERT_INTO("CORE_SIEE.TT_MAP_CATALOGO");
				VALUES("NU_ID_ITEM","tt_map_catalogo_seq.nextval");
				VALUES("NU_ID_CATALOGO","#{idCatalogo, jdbcType=INTEGER}");
				VALUES("TX_ITEM_VALOR","#{valor, jdbcType=VARCHAR}");
				VALUES("TX_ITEM_ETIQUETA","#{etiqueta, jdbcType=VARCHAR}");
				VALUES("TX_ITEM_DESCRIPCION","#{descripcion, jdbcType=VARCHAR}");
			}
		}.toString();
	}

    public String modificar(DTOCatalogoSolicitud solicitud) {
		return new SQL() {
			{
				UPDATE("CORE_SIEE.TT_MAP_CATALOGO");
				SET("NU_ID_CATALOGO = #{idCatalogo, jdbcType=INTEGER}");
				SET("TX_ITEM_VALOR = #{valor, jdbcType=VARCHAR}");
				SET("TX_ITEM_ETIQUETA = #{etiqueta, jdbcType=VARCHAR}");
				SET("TX_ITEM_DESCRIPCION = #{descripcion,  jdbcType=VARCHAR}");
				WHERE("NU_ID_ITEM = #{idItem, jdbcType=INTEGER}");
			}
		}.toString();
	}

    public String setEstado(DTOCatalogoSolicitud solicitud) {
		return new SQL() {
			{
				UPDATE("CORE_SIEE.TT_MAP_CATALOGO");
                SET("TX_ITEM_ACTIVO = #{activo, jdbcType=VARCHAR}");       
                WHERE("NU_ID_ITEM = #{idItem, jdbcType=INTEGER}");
			}
		}.toString();
	}

	public String eliminar(DTOCatalogoSolicitud solicitud) {
		return new SQL() {
			{
				UPDATE("CORE_SIEE.TT_MAP_CATALOGO");
                SET("TX_REGISTRO_ACTIVO = #{regisActivo, jdbcType=VARCHAR}");       
                WHERE("NU_ID_ITEM = #{idItem, jdbcType=INTEGER}");
			}
		}.toString();
	}

	public String validar(DTOCatalogoSolicitud solicitud) {
        return new SQL() {
            {
                SELECT("C.NU_ID_ITEM idItem");
                SELECT("C.TX_ITEM_VALOR valor");
                SELECT("C.TX_REGISTRO_ACTIVO regisActivo");
                SELECT("C.TX_ITEM_ACTIVO activo");              
                FROM("CORE_SIEE.TT_MAP_CATALOGO C");               
		        WHERE("C.TX_ITEM_ACTIVO = '1'");
                WHERE("C.TX_REGISTRO_ACTIVO = '1'");
                WHERE("C.TX_ITEM_VALOR = #{valor, jdbcType=VARCHAR}");
            }
        }.toString();
    }

}
