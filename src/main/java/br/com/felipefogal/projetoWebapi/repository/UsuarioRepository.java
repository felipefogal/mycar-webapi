package br.com.felipefogal.projetoWebapi.repository;

import br.com.felipefogal.projetoWebapi.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

    Optional<Usuario> findByUserName(String userName);

    void deleteByUserName(String userName);
}
