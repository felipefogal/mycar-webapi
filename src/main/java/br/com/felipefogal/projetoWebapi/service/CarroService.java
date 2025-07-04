package br.com.felipefogal.projetoWebapi.service;

import br.com.felipefogal.projetoWebapi.model.Carro;
import br.com.felipefogal.projetoWebapi.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public boolean deletarPorId(String id) {
        Optional<Carro> carro = repository.findById(id);
        if (carro.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
