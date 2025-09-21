package br.com.felipefogal.projetoWebapi.service;

import br.com.felipefogal.projetoWebapi.model.Oficina;
import br.com.felipefogal.projetoWebapi.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OficinaService {

    @Autowired
    private OficinaRepository repository;

    public boolean deletarPorId(String id) {
        Optional<Oficina> oficina = repository.findById(id);
        if (oficina.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
