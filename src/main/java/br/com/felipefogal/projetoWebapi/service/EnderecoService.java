package br.com.felipefogal.projetoWebapi.service;

import br.com.felipefogal.projetoWebapi.model.Endereco;
import br.com.felipefogal.projetoWebapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public boolean deletarPorId(String id) {
        Optional<Endereco> endereco = repository.findById(id);
        if (endereco.isPresent()) {
        repository.deleteById(id);
            return true;
        }
        return false;
    }
}
