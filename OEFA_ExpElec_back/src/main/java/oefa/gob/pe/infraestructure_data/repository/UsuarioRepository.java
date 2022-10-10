package oefa.gob.pe.infraestructure_data.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import oefa.gob.pe.application_dto.autenticacion.DTOUsuario;
import oefa.gob.pe.application_dto.autenticacion.DTOUsuarioSolicitud;
import oefa.gob.pe.infraestructure_data.mapper.UsuarioMapper;
import java.util.List;

@Mapper
public interface UsuarioRepository {
    @SelectProvider(type = UsuarioMapper.class, method = "obtenerUsuario")
    List<DTOUsuario> obtenerUsuario(DTOUsuarioSolicitud solicitud);
}
