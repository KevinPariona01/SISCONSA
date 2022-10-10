package oefa.gob.pe.archivo.infrastructure.data.mapper;

import oefa.gob.pe.archivo.application.dto.archivo.DTOArchivo;
import oefa.gob.pe.archivo.application.dto.archivo.DTOArchivoSolicitud;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

@Mapper
public class ArchivoMapper {

	public String listar(DTOArchivoSolicitud solicitud) {
		return new SQL() {
			{
				
			}
		}.toString();
	}

	public String consultar(DTOArchivoSolicitud solicitud) {
		return new SQL() {
			{
				SELECT("ID_ARCHIVO_ALFRESCO idArchivo");
				SELECT("NOMBRE_ARCHIVO nombreArchivo");
				SELECT("RUTA_ALFRESCO rutaAlfresto");
				SELECT("UIID uiid");
				FROM("MONITOREO.T_MAP_ARCHIVO_ALFRESCO");
				WHERE("ID_ARCHIVO_ALFRESCO = #{idArchivo}");
				WHERE("FG_SITREG = '1'");
			}
		}.toString();
	}

	public String agregar(DTOArchivo solicitud) {
		return new SQL() {
			{
				INSERT_INTO("MONITOREO.T_MAP_ARCHIVO_ALFRESCO ");
				if (solicitud.nombreArchivo != null) {
					VALUES("TX_NOMBRE_ARCHIVO_ORIGINAL", "#{nombreArchivo, jdbcType=VARCHAR}");
				}
				if (solicitud.rutaAlfresto != null) {
					VALUES("TX_RUTA_ALFRESCO", "#{rutaAlfresto, jdbcType=VARCHAR}");
				}
				if (solicitud.uiid != null) {
					VALUES("TX_UIID", "#{uiid, jdbcType=VARCHAR}");
				}
				if (solicitud.audCreadoPor != null) {
					VALUES("AUD_CREADO_POR", "#{audCreadoPor, jdbcType=VARCHAR}");
				}
				VALUES("NU_FOLIOS", "#{nroFolios, jdbcType=INTEGER}");
				VALUES("AUD_FECHA_CREACION", "SYSDATE");
			}
		}.toString();
	}

	public String modificar(DTOArchivo solicitud) {
		return new SQL() {
			{
				UPDATE("MONITOREO.T_MAP_ARCHIVO_ALFRESCO");
				SET("NOMBRE_ARCHIVO = #{nombreArchivo, jdbcType=VARCHAR}");
				SET("RUTA_ALFRESCO = #{rutaAlfresto, jdbcType=VARCHAR}");
				SET("UIID = #{uiid, jdbcType=VARCHAR}");
				SET("AUD_MODIFICADO_POR = #{audModificadoPor, jdbcType=VARCHAR}");
				SET("AUD_FECHA_MODIFICACION = sysdate");
				WHERE("ID_ARCHIVO_ALFRESCO = #{idArchivo, jdbcType=INTEGER}");
			}
		}.toString();
	}

	public String eliminar(DTOArchivo solicitud) {
		return new SQL() {
			{
				UPDATE("MONITOREO.T_MAP_ARCHIVO_ALFRESCO");
				SET("FG_SITREG = '0'");
				WHERE("ID_ARCHIVO = #{idArchivo, jdbcType=INTEGER}");
			}
		}.toString();
	}

	public String obtenerUltimoId() {
		return new SQL() {
			{
				SELECT("NVL(MAX(ID_ARCHIVO), 0)");
				FROM("MONITOREO.T_MAP_ARCHIVO_ALFRESCO");
			}
		}.toString();
	}

	public String obtenerUltimoIdAlf() {
		return new SQL() {
			{
				SELECT("NVL(MAX(ID_ARCHIVO), 0)");
				FROM("MONITOREO.T_MAP_ARCHIVO_ALFRESCO");
				WHERE("TX_UIID IS NULL");
			}
		}.toString();
	}

	public String actualizarAlfresco(DTOArchivo p) {
		return new SQL() {
			{
			
			}
		}.toString();
	}

	public String obtenerArchivo(DTOArchivo p) {
		return new SQL() {
			{
				
			}
		}.toString();
	}

	public String obtenerArchivo02(DTOArchivo p) {
		return new SQL() {
			{

			}
		}.toString();
	}

	public String quitarTramiteArchivo(DTOArchivo p) {
		return new SQL() {
			{

			}
		}.toString();
	}
}