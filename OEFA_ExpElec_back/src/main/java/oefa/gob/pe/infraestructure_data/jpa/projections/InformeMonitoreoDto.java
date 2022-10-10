package oefa.gob.pe.infraestructure_data.jpa.projections;

import oefa.gob.pe.application_dto.informe_monitoreo.DTOInformeMonitoreo;
import oefa.gob.pe.infraestructure_cross_cuting.util.Helpers;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

public interface InformeMonitoreoDto {
    Long getIdInformeMonitoreo();

    String getIdSubsector();

    String getCodigoUfi();

    String getRucAdministrado();

    String getIdUfi();

    String getNombreInformeMonitoreo();

    @Nullable
    LocalDate getFechaPresentacion();

    Long getIdEtapa();

    Long getIdFrecuenciaReporte();

    String getIdPeriodo();

    default DTOInformeMonitoreo toDTOInformeMonitoreo() {
        var dto = new DTOInformeMonitoreo();
        dto.idInformeMonitoreo = Math.toIntExact(this.getIdInformeMonitoreo());
        dto.idSubsector = this.getIdSubsector();
        dto.codigoUfi = this.getCodigoUfi();
        dto.rucAdministrado = this.getRucAdministrado();
        dto.idUfi = this.getIdUfi();
        dto.nombreInformeMonitoreo = this.getNombreInformeMonitoreo();
        dto.fechaPresentacion = Helpers.localDateToDate(this.getFechaPresentacion());
        dto.idEtapa = String.valueOf(this.getIdEtapa());
        dto.idFrecuenciaReporte = String.valueOf(this.getIdFrecuenciaReporte());
        dto.idPeriodo = this.getIdPeriodo();
        return dto;
    }
}
