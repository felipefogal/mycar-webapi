package br.com.felipefogal.projetoWebapi.controller;

import br.com.felipefogal.projetoWebapi.model.Carro;
import br.com.felipefogal.projetoWebapi.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @PostMapping
    public ResponseEntity<?> criarCarro(@RequestBody Carro carro) {
        carroRepository.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carro);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        List<Carro> carros = carroRepository.findAll();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<?> buscaPorNome(@PathVariable String nome) {
        return carroRepository.findByNome(nome).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    static class Mensagem {
        private String message;

        public Mensagem(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message){
            this.message = message;
        }
    }
}
