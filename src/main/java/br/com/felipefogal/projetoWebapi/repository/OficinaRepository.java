package br.com.felipefogal.projetoWebapi.repository;

import br.com.felipefogal.projetoWebapi.model.Oficina;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OficinaRepository extends MongoRepository<Oficina, String> {
    Optional<Oficina> findById(String id);
    Optional<Oficina> findByNome(String nome);
    void deleteById(String id);
}
