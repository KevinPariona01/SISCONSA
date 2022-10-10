package oefa.gob.pe.infraestructure_data.jpa.repository;

import oefa.gob.pe.infraestructure_data.jpa.model.TMapTipo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface TipoRepository {
    CompletableFuture<List<TMapTipo>> listar(String tipoParametro);
}
