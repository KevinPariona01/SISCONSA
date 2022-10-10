package oefa.gob.pe.infraestructure_data.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import oefa.gob.pe.application_dto.catalogo.DTOCatalogo;
import oefa.gob.pe.application_dto.catalogo.DTOCatalogoSolicitud;
import oefa.gob.pe.infraestructure_data.mapper.CatalogoMapper;


@Mapper
public interface CatalogoRepository {
    @SelectProvider(type = CatalogoMapper.class, method = "listar")
    List<DTOCatalogo> listar(DTOCatalogoSolicitud solicitud);

    @SelectProvider(type = CatalogoMapper.class, method = "listarPadre")
    List<DTOCatalogo> listarPadre(DTOCatalogoSolicitud solicitud);

    @SelectProvider(type = CatalogoMapper.class, method = "insertar")
    void insertar(DTOCatalogoSolicitud solicitud);

    @SelectProvider(type = CatalogoMapper.class, method = "modificar")
    void modificar(DTOCatalogoSolicitud solicitud);

    @SelectProvider(type = CatalogoMapper.class, method = "eliminar")
    void eliminar(DTOCatalogoSolicitud solicitud);

    @SelectProvider(type = CatalogoMapper.class, method = "setEstado")
    void setEstado(DTOCatalogoSolicitud solicitud);

    @SelectProvider(type = CatalogoMapper.class, method = "validar")
    List<DTOCatalogo> validar(DTOCatalogoSolicitud solicitud);


}
