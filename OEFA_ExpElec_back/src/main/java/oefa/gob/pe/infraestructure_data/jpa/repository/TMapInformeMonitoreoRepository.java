package oefa.gob.pe.infraestructure_data.jpa.repository;

import oefa.gob.pe.infraestructure_data.jpa.model.TMapInformeMonitoreo;
import oefa.gob.pe.infraestructure_data.jpa.projections.InformeMonitoreoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface ListarImaProy {

}

public interface TMapInformeMonitoreoRepository extends JpaRepository<TMapInformeMonitoreo, Long>, JpaSpecificationExecutor<TMapInformeMonitoreo> {
    @Query("""
            select distinct
                mim.id as idInformeMonitoreo,
                mim.codSubsector as idSubsector,
                mim.txCodUnidadFiscalizable as codigoUfi,
                mim.txRucAdministrado as rucAdministrado,
                vis.codUf as idUfi,
                mim.txNombre as nombreInformeMonitoreo,
                mim.feFechaPresentacion as fechaPresentacion,
                mim.idEtapa as idEtapa,
                mim.idFrecReporte as idFrecuenciaReporte,
                mim.idPeriodo as idPeriodo
            from TMapInformeMonitoreo mim
                inner join VwAdminUfSubst vis on mim.txCodUnidadFiscalizable = vis.codUf
            where mim.id = :idInformeMonitoreo
                and mim.fgSitreg = true
            """)
    InformeMonitoreoDto consultar(@Param("idInformeMonitoreo") Long idInformeMonitoreo);

    @Query("""
             select
                 mim
             from TMapInformeMonitoreo mim
                 inner join TMapTipo t1 on t1.txCodTipo = concat(mim.idEtapa,'') and t1.txDescGrupo = 'ETAPA'
                 inner join TMapTipo t2 on t2.txCodTipo = concat(mim.idFrecReporte,'') and t2.txDescGrupo = 'FRECUENCIA_REPORTE'
                 inner join TMapTipo t3 on t3.txCodTipo = concat(mim.idPeriodo,'') and t3.txDescGrupo = 'PERIODO_PRESENTACION'
                 left outer join VwNombreInforInst t4 on t4.idInformeMonitoreo = mim.id
            """)
    List<ListarImaProy> listar();
}