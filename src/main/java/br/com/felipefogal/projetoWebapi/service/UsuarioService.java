package br.com.felipefogal.projetoWebapi.service;

import br.com.felipefogal.projetoWebapi.model.Usuario;
import br.com.felipefogal.projetoWebapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    
    private UsuarioRepository repository;

    public boolean deletarPorUserName(String userName){
        Optional<Usuario> usuario = repository.findByUserName(userName);
        if (usuario.isPresent()) {
            repository.delete
        }
    }
}
