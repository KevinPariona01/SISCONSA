package oefa.gob.pe.infraestructure_data.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import oefa.gob.pe.application_dto.documento.DTODocumento;
import oefa.gob.pe.application_dto.documento.DTODocumentoSolicitud;
import oefa.gob.pe.infraestructure_data.mapper.DocumentoMapper;

@Mapper
public interface DocumentoRepository {
    
    @SelectProvider(type = DocumentoMapper.class, method = "listar")
    List<DTODocumento> listar(DTODocumentoSolicitud solicitud);

    @SelectProvider(type = DocumentoMapper.class, method = "insertar")
    void insertar(DTODocumentoSolicitud solicitud);

    @SelectProvider(type = DocumentoMapper.class, method = "insertarComentario")
    void insertarComentario(DTODocumentoSolicitud solicitud);

}
