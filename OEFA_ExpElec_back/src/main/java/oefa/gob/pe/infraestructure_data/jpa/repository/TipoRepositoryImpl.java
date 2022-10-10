package oefa.gob.pe.infraestructure_data.jpa.repository;

import oefa.gob.pe.infraestructure_data.jpa.model.TMapTipo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class TipoRepositoryImpl implements TipoRepository {
    private final TMapTipoRepositoryJpa repositoryJpa;

    public TipoRepositoryImpl(TMapTipoRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public CompletableFuture<List<TMapTipo>> listar(String tipoParametro) {
        if (tipoParametro.equals("ZONA_SIN_INFORMACION")) {
            return repositoryJpa.findAllByTxDescGrupoAndTxCodTipoPadreIsOrderByTxDescripcion("ZONA", "100");
        } else {
            return repositoryJpa.findAllByTxDescGrupoOrderByTxDescripcion(tipoParametro);
        }
    }
}
