package oefa.gob.pe.infraestructure_data.jpa.repository;

import oefa.gob.pe.infraestructure_data.jpa.model.TMvcDenylistInforme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TMvcDenylistInformeRepository extends JpaRepository<TMvcDenylistInforme, Long>, JpaSpecificationExecutor<TMvcDenylistInforme> {
    boolean existsByRuc(String ruc);
}