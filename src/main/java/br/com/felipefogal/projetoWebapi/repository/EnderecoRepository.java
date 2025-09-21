package br.com.felipefogal.projetoWebapi.repository;

import br.com.felipefogal.projetoWebapi.model.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EnderecoRepository extends MongoRepository<Endereco, String> {
    Optional<Endereco> findById(String id);
    void deleteById(String id);
}
