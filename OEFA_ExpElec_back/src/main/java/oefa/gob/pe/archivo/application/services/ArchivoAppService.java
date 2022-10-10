package oefa.gob.pe.archivo.application.services;

import oefa.gob.pe.archivo.application.dto.archivo.DTOArchivo;
import oefa.gob.pe.archivo.application.dto.archivo.DTOArchivoSolicitud;
import oefa.gob.pe.archivo.infrastructure.data.repository.ArchivoRepository;
import oefa.gob.pe.infraestructure_data.mapper.TMapArchivoAlfrescoMapper;
import oefa.gob.pe.infraestructure_data.model.TMapArchivoAlfresco;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ArchivoAppService {

    private final ArchivoRepository auditorAmbientalRepository;
    private final TMapArchivoAlfrescoMapper archivoAlfrescoMapper;

    public ArchivoAppService(final ArchivoRepository auditorAmbientalRepository, TMapArchivoAlfrescoMapper archivoAlfrescoMapper) {
        this.auditorAmbientalRepository = auditorAmbientalRepository;
        this.archivoAlfrescoMapper = archivoAlfrescoMapper;
    }

    public List<DTOArchivo> listar(DTOArchivoSolicitud solicitud) {
        return auditorAmbientalRepository.listar(solicitud);
    }

    public DTOArchivo consultar(DTOArchivoSolicitud solicitud) {
        return auditorAmbientalRepository.consultar(solicitud);
    }

    public Long agregar(DTOArchivo solicitud) {
        var dao = new TMapArchivoAlfresco();
        dao.setTxNombreArchivoOriginal(solicitud.nombreArchivo);
        dao.setTxRutaAlfresco(solicitud.rutaAlfresto);
        dao.setTxUiid(solicitud.uiid);
        dao.setAudCreadoPor(solicitud.audCreadoPor);
        dao.setNuFolios(BigDecimal.valueOf(solicitud.nroFolios));
        dao.setAudFechaCreacion(LocalDateTime.now());
        archivoAlfrescoMapper.insertReturningId(dao);
        return dao.getIdArchivo().longValue();
    }

    public void modificar(DTOArchivo solicitud) {
        auditorAmbientalRepository.modificar(solicitud);
    }

    public void eliminar(DTOArchivo solicitud) {
        auditorAmbientalRepository.eliminar(solicitud);
    }

    public void eliminarById(Long id) {
        archivoAlfrescoMapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
    }

    public int obtenerUltimoId() {
        return auditorAmbientalRepository.obtenerUltimoId();
    }

    public int obtenerUltimoIdAlf() {
        return auditorAmbientalRepository.obtenerUltimoIdAlf();
    }

    public void actualizarAlfresco(DTOArchivo solicitud) {
        auditorAmbientalRepository.actualizarAlfresco(solicitud);
    }

    public DTOArchivo obtenerArchivo(DTOArchivo param){
        return  auditorAmbientalRepository.obtenerArchivo(param);
    }

    public DTOArchivo obtenerArchivo02(DTOArchivo param){
        return  auditorAmbientalRepository.obtenerArchivo02(param);
    }

    public void quitarTramiteArchivo(DTOArchivo param){
        auditorAmbientalRepository.quitarTramiteArchivo(param);
    }
}