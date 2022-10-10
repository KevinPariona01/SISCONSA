package oefa.gob.pe.infraestructure_data.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import oefa.gob.pe.application_dto.procesos.DTOProcesoSolicitud;
import oefa.gob.pe.application_dto.procesos.DTOProcesos;
import oefa.gob.pe.infraestructure_data.mapper.ProcesosMapper;

@Mapper
public interface ProcesosRepository {
    @SelectProvider(type = ProcesosMapper.class, method = "listar")
    List<DTOProcesos> listar(DTOProcesoSolicitud solicitud);

    @SelectProvider(type = ProcesosMapper.class, method = "agregar")
    void agregar(DTOProcesoSolicitud solicitud);

    @SelectProvider(type = ProcesosMapper.class, method = "editar")
    void editar(DTOProcesoSolicitud solicitud);

    @SelectProvider(type = ProcesosMapper.class, method = "eliminar")
    void eliminar(DTOProcesoSolicitud solicitud);

    @SelectProvider(type = ProcesosMapper.class, method = "validar")
    List<DTOProcesos> validar(DTOProcesoSolicitud solicitud);

    @SelectProvider(type = ProcesosMapper.class, method = "setEstado")
    void setEstado(DTOProcesoSolicitud solicitud);


    
}
