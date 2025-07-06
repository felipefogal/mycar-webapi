package br.com.felipefogal.projetoWebapi.controller;

import br.com.felipefogal.projetoWebapi.model.Usuario;
import br.com.felipefogal.projetoWebapi.repository.UsuarioRepository;
import br.com.felipefogal.projetoWebapi.service.UsuarioService;
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

    @Autowired
    private UsuarioService usuarioService;

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

    @GetMapping("/username/{userName}")
    @Operation(summary = "Lista usuário específico", description = "Retorna um usuário específico de acordo com seu username")
    public ResponseEntity<?> buscarPorUserName(@PathVariable String userName) {
        return usuarioRepository.findByUserName(userName).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/username/{id}")
    @Operation(summary = "Deleta usuário específico", description = "Remove um usuário de acordo com o username informado")
    public ResponseEntity<String> deletarUsuarioPorId(@PathVariable String id) {
        boolean usuarioDeletado = usuarioService.deletarPorId(id);
        if (usuarioDeletado) {
            return ResponseEntity.ok("Usuario " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario " + id + " não encontrado na base");
        }
    }
}
