package oefa.gob.pe.infraestructure_data.jpa.repository;

import oefa.gob.pe.infraestructure_data.jpa.projections.LaboratorioDetalleDto;

import java.util.concurrent.CompletableFuture;


public interface VwAccionSupervisionRepository {
    CompletableFuture<LaboratorioDetalleDto> laboratorioDetalle(String tipoModulo, String codigoAccion);
}
