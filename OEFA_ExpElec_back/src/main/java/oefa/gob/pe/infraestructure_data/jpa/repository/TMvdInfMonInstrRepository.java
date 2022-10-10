package oefa.gob.pe.infraestructure_data.jpa.repository;

import oefa.gob.pe.infraestructure_data.jpa.model.TMvdInfMonInstr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TMvdInfMonInstrRepository extends JpaRepository<TMvdInfMonInstr, Long>, JpaSpecificationExecutor<TMvdInfMonInstr> {
    @Async
    @Query("select t.idInstrumento from TMvdInfMonInstr t where t.idInformeMonitoreo = :idInformeMonitoreo")
    CompletableFuture<List<Long>> findAllByIdInformeMonitoreo(@Param("idInformeMonitoreo") Long idInformeMonitoreo);
}