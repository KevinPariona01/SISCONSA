package oefa.gob.pe.archivo.infrastructure.data.repository;

import oefa.gob.pe.archivo.application.dto.archivo.DTOArchivo;
import oefa.gob.pe.archivo.application.dto.archivo.DTOArchivoSolicitud;
import oefa.gob.pe.archivo.infrastructure.data.mapper.ArchivoMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;


@Mapper
public interface ArchivoRepository {
    @SelectProvider(type = ArchivoMapper.class, method = "listar")
    List<DTOArchivo> listar(DTOArchivoSolicitud solicitud);

    @SelectProvider(type = ArchivoMapper.class, method = "consultar")
    DTOArchivo consultar(DTOArchivoSolicitud solicitud);

    @SelectProvider(type = ArchivoMapper.class, method = "agregar")
    void agregar(DTOArchivo solicitud);

    @SelectProvider(type = ArchivoMapper.class, method = "modificar")
    void modificar(DTOArchivo solicitud);

    @SelectProvider(type = ArchivoMapper.class, method = "eliminar")
    void eliminar(DTOArchivo solicitud);

    @SelectProvider(type = ArchivoMapper.class, method = "obtenerUltimoId")
    int obtenerUltimoId();

    @SelectProvider(type = ArchivoMapper.class, method = "obtenerUltimoIdAlf")
    int obtenerUltimoIdAlf();

    @SelectProvider(type = ArchivoMapper.class, method = "actualizarAlfresco")
    void actualizarAlfresco(DTOArchivo solicitud);

    @SelectProvider(type = ArchivoMapper.class, method = "obtenerArchivo")
    DTOArchivo obtenerArchivo(DTOArchivo parametroTramite);
    
    @SelectProvider(type = ArchivoMapper.class, method = "obtenerArchivo02")
    DTOArchivo obtenerArchivo02(DTOArchivo parametroTramite);

    @SelectProvider(type = ArchivoMapper.class, method = "quitarTramiteArchivo")
    DTOArchivo quitarTramiteArchivo(DTOArchivo parametroTramite);

}