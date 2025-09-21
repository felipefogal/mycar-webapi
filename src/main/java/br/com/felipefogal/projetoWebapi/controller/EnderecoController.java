package br.com.felipefogal.projetoWebapi.controller;

import br.com.felipefogal.projetoWebapi.model.Endereco;
import br.com.felipefogal.projetoWebapi.repository.EnderecoRepository;
import br.com.felipefogal.projetoWebapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@Tag(name = "Endereços", description = "Gerenciamento de endereços de usuários, garagens, oficinas etc")
public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    @Operation(summary = "Listagem de Endereços", description = "Listagem de todos os endereços")
    public ResponseEntity<List<Endereco>> listaEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return ResponseEntity.ok(enderecos);
    }

   @GetMapping("/{id}")
   @Operation(summary = "Lista endereço", description = "Listagem de endereço pelo seu id")
   public ResponseEntity<?> buscaEnderecoPorId(@PathVariable String id) {
        return enderecoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
   }

    @PostMapping
    @Operation()
    public ResponseEntity<?> criarEndereco(@RequestBody Endereco endereco) {
        enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }
}
