package br.com.felipefogal.projetoWebapi.service;

import br.com.felipefogal.projetoWebapi.model.Usuario;
import br.com.felipefogal.projetoWebapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public boolean deletarPorId(String id){
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
