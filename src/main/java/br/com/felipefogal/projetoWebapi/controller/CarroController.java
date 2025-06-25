package br.com.felipefogal.projetoWebapi.controller;

import br.com.felipefogal.projetoWebapi.model.Carro;
import br.com.felipefogal.projetoWebapi.repository.CarroRepository;
import br.com.felipefogal.projetoWebapi.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@Tag(name = "Carros", description = "Controller do gerenciamento de carros")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroService service;

    @PostMapping
    @Operation(summary = "Cria carros novos", description = "Endpoint para a criação de carros novos")
    public ResponseEntity<?> criarCarro(@RequestBody Carro carro) {
        carroRepository.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carro);
    }

    @GetMapping
    @Operation(summary = "Lista todos os carros", description = "Retorna todos os carros do sistema")
    public ResponseEntity<List<Carro>> listarCarros() {
        List<Carro> carros = carroRepository.findAll();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{nome}")
    @Operation(summary = "Lista um carro específico", description = "Retorna os dados de um carro específico")
    public ResponseEntity<?> buscaPorNome(@PathVariable String nome) {
        return carroRepository.findByNome(nome).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{nome}")
    @Operation(summary = "Deleta um carro específico", description = "Exclui um carro específico de acordo com o nome informado")
    public ResponseEntity<String> deletarCarroPorNome(@PathVariable String nome) {
        boolean deletado = service.deletarPorNome(nome);
        if (deletado) {
            return ResponseEntity.ok("Carro com nome " + nome + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro com nome " + nome + " não encontrado");
        }
    }
}
