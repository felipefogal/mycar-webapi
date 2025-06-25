package br.com.felipefogal.projetoWebapi.controller;

import br.com.felipefogal.projetoWebapi.model.Usuario;
import br.com.felipefogal.projetoWebapi.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Controller do gerenciamento de usuários do sistema")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Operation(summary = "Cria usuários", description = "Endpoint para criação de novos usuários")
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping
    @Operation(summary = "Lista todos os usuários", description = "Retorna todos os usuários existentes no sistema")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{userName}")
    @Operation(summary = "Lista usuário específico", description = "Retorna um usuário específico de acordo com seu username")
    public ResponseEntity<?> buscarPorUserName(@PathVariable String userName) {
        return usuarioRepository.findByUserName(userName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
