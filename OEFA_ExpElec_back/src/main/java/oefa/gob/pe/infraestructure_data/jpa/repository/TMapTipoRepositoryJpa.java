package oefa.gob.pe.infraestructure_data.jpa.repository;

import oefa.gob.pe.infraestructure_data.jpa.model.TMapTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface TMapTipoRepositoryJpa extends JpaRepository<TMapTipo, Long>, JpaSpecificationExecutor<TMapTipo> {
    @Async
    CompletableFuture<List<TMapTipo>> findAllByTxDescGrupoAndTxCodTipoPadreIsOrderByTxDescripcion(String descGrupo, String codTipo);

    @Async
    CompletableFuture<List<TMapTipo>> findAllByTxDescGrupoOrderByTxDescripcion(String descGrupo);
}