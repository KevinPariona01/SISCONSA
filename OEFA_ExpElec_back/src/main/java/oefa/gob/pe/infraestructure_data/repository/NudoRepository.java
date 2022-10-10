package oefa.gob.pe.infraestructure_data.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import oefa.gob.pe.application_dto.nudo.DTONudoSolicitud;
import oefa.gob.pe.application_dto.nudo.DTONudos;
import oefa.gob.pe.infraestructure_data.mapper.NudoMapper;

@Mapper
public interface NudoRepository {

    @SelectProvider(type = NudoMapper.class, method = "listar")
    List<DTONudos> listar(DTONudoSolicitud solicitud);

    @SelectProvider(type = NudoMapper.class, method = "listarPadre")
    List<DTONudos> listarPadre(DTONudoSolicitud solicitud);

    @SelectProvider(type = NudoMapper.class, method = "listarDepartamentos")
    List<DTONudos> listarDepartamentos(DTONudoSolicitud solicitud);

    @SelectProvider(type = NudoMapper.class, method = "insertarNudoUbigeo")
    void insertarNudoUbigeo(DTONudoSolicitud solicitud);

    @SelectProvider(type = NudoMapper.class, method = "insertarNudo")
    void insertarNudo(DTONudoSolicitud solicitud);

    @SelectProvider(type = NudoMapper.class, method = "setEstadoNudoUbigeo")
    void setEstadoNudoUbigeo(DTONudoSolicitud solicitud);

    @SelectProvider(type = NudoMapper.class, method = "eliminarNudoUbigeo")
    void eliminarNudoUbigeo(DTONudoSolicitud solicitud);

    @SelectProvider(type = NudoMapper.class, method = "eliminarNudo")
    void eliminarNudo(DTONudoSolicitud solicitud);

    @SelectProvider(type = NudoMapper.class, method = "eliminarNudoUbigeoConNudo")
    void eliminarNudoUbigeoConNudo(DTONudoSolicitud solicitud);


}
