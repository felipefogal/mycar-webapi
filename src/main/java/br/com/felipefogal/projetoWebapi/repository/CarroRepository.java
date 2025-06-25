package br.com.felipefogal.projetoWebapi.repository;

import br.com.felipefogal.projetoWebapi.model.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarroRepository extends MongoRepository<Carro, Long> {

    Optional<Carro> findByNome(String nome);
}
