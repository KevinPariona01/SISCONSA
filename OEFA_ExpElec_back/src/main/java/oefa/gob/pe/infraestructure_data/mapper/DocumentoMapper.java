package oefa.gob.pe.infraestructure_data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import oefa.gob.pe.application_dto.documento.DTODocumentoSolicitud;

@Mapper
public class DocumentoMapper {
    
    public String listar(DTODocumentoSolicitud solicitud) {
		return new SQL() {
			{
				SELECT("D.N_ID_HTML id");
				SELECT("D.TX_HTML html");
				//SELECT("C.TX_TITULO_DOCUMENTO documento");
				//SELECT("C.TX_COMENTARIO comentario");
				FROM("CORE_SIEE.T_MAP_DOCUMENTO D");
			}
		}.toString();
	}

    public String insertar(DTODocumentoSolicitud solicitud) {
		return new SQL() {
			{
				INSERT_INTO("CORE_SIEE.T_MAP_DOCUMENTO");
				VALUES("N_ID_HTML","#{id, jdbcType=INTEGER }");
				VALUES("TX_HTML","#{html, jdbcType=VARCHAR}");
			}
		}.toString();
	}

}
