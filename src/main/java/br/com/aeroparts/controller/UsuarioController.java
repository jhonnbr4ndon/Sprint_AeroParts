
package br.com.aeroparts.controller;

import br.com.aeroparts.controller.dto.UsuarioDTO;
import br.com.aeroparts.service.UsuarioService;
import br.com.aeroparts.entity.Usuario;
import br.com.aeroparts.service.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioDTO>> listaUsuarios() {
        List<UsuarioDTO> usuarioDTO = usuarioService.listarUsuarios().stream().map(UsuarioMapper::entityDTO).toList();
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> encontrarUsuarioPorID(@PathVariable Long id) {
        Usuario usuario = usuarioService.encontrarUsuarioPorID(id);
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuario));
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> criarNovoUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.criarUsuario(UsuarioMapper.entity(usuarioDTO));
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizaUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.atualizaUsuario(id, UsuarioMapper.entity(usuarioDTO));
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
