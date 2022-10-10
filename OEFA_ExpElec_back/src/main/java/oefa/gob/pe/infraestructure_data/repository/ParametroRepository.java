package oefa.gob.pe.infraestructure_data.repository;

import oefa.gob.pe.application_dto.Parametro.DTOParametro;
import oefa.gob.pe.infraestructure_data.mapper.ParametroMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface ParametroRepository {

    @Cacheable(value = "5m", key = "#p.tipoParametro")
    @SelectProvider(type = ParametroMapper.class, method = "listar")
    List<DTOParametro> listar(DTOParametro p);

    @Cacheable(value = "10m", key = "'listarSignoRestringido'")
    @SelectProvider(type = ParametroMapper.class, method = "listarSignoRestringido")
    List<DTOParametro> listarSignoRestringido();

    @Cacheable(value = "5m")
    @SelectProvider(type = ParametroMapper.class, method = "listarHijo")
    List<DTOParametro> listarHijo(DTOParametro p);

    @SelectProvider(type = ParametroMapper.class, method = "correlativoCodigoPunto")
    String correlativoCodigoPunto();

    @SelectProvider(type = ParametroMapper.class, method = "modificarContador")
    void modificarContador(DTOParametro p);

    @SelectProvider(type = ParametroMapper.class, method = "obtenerIdFrecuenciaReporte")
    DTOParametro obtenerIdFrecuenciaReporte(DTOParametro p);

    @SelectProvider(type = ParametroMapper.class, method = "obtenerIdFrecuenciaReportePuntoAdicional")
    DTOParametro obtenerIdFrecuenciaReportePuntoAdicional(DTOParametro p);
}
