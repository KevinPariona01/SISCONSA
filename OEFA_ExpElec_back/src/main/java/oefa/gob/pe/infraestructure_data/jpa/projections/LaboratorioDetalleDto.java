package oefa.gob.pe.infraestructure_data.jpa.projections;

import oefa.gob.pe.application_dto.informe_monitoreo.DTOLaboratorioDetalle;

public interface LaboratorioDetalleDto {
    String getSubSector();

    String getUnidadFiscalizable();

    String getAdministrado();

    String getUnidadEvaluacion();

    String getAreaEstudio();

    default DTOLaboratorioDetalle toDTOLaboratorioDetalle() {
        var dto = new DTOLaboratorioDetalle();
        dto.subSector = getSubSector();
        dto.unidadFiscalizable = getUnidadFiscalizable();
        dto.administrado = getAdministrado();
        dto.unidadEvaluacion = getUnidadEvaluacion();
        dto.areaEstudio = getAreaEstudio();
        return dto;
    }
}
