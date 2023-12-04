package br.com.aeroparts.controller;

import br.com.aeroparts.entity.Usuario;
import br.com.aeroparts.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obterUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Usuario> mostrarUsuarios() {
        return usuarioService.mostrarUsuario();
    }

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(201).body("Usuario criado com sucesso. ID do Usuario: " + novoUsuario.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioService.obterUsuarioPorId(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());

            usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok("Usuario atualizado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok("Usuario deletado com sucesso.");
    }
}