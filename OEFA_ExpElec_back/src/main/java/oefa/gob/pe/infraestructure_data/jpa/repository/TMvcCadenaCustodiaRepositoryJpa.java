package oefa.gob.pe.infraestructure_data.jpa.repository;

import oefa.gob.pe.infraestructure_data.jpa.model.TMvcCadenaCustodia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TMvcCadenaCustodiaRepositoryJpa extends JpaRepository<TMvcCadenaCustodia, Long>, JpaSpecificationExecutor<TMvcCadenaCustodia> {

    @Query("""
            select tcc.idCadenaCustodia from TMvcCadenaCustodia tcc
                inner join TMvcPlanMonitoreo mpl on mpl.id = tcc.idPlanMonitoreo
            where tcc.idPlanMonitoreo = :idPlanMonitoreo
            """)
    Long consultarIdCustodia(@Param("idPlanMonitoreo") Long idPlanMonitoreo);
}