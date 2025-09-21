package br.com.felipefogal.projetoWebapi.controller;

import br.com.felipefogal.projetoWebapi.model.Oficina;
import br.com.felipefogal.projetoWebapi.repository.OficinaRepository;
import br.com.felipefogal.projetoWebapi.service.OficinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oficina")
@Tag(name= "Oficinas", description = "Controller do gerenciamento de oficinas")
public class OficinaController {
    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired
    private OficinaService oficinaService;

    @GetMapping
    @Operation(summary = "Listagem de oficinas", description = "Retorna a listagem de todas as oficinas cadastradas")
    public ResponseEntity<List<Oficina>> listarOficinas() {
        List<Oficina> oficinas = oficinaRepository.findAll();
        return ResponseEntity.ok(oficinas);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Lista oficina específica", description = "Lista uma oficina pelo seu id")
    public ResponseEntity<?> buscaOficinaPorId(@PathVariable String id){
        return oficinaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    @Operation(summary = "Lista oficina específica", description = "Lista oficina pelo seu nome")
    public ResponseEntity<?> buscaOficinaPorNome(@PathVariable String nome) {
        return oficinaRepository.findByNome(nome).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria uma nova oficina", description = "Cria uma nova oficina")
    public ResponseEntity<?> criaOficina(@RequestBody Oficina oficina) {
        oficinaRepository.save(oficina);
        return ResponseEntity.status(HttpStatus.CREATED).body(oficina);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar oficina", description = "Deletar oficina por id")
    public ResponseEntity<String> deletarOficina(@PathVariable String id) {
        boolean deletado = oficinaService.deletarPorId(id);
        if (deletado) {
            return ResponseEntity.ok("Oficina " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oficina de id: " + id + " não foi encontrada na base");
        }
    }

}
