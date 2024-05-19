
package br.com.aeroparts.controller;

import br.com.aeroparts.controller.dto.UsuarioDTO;
import br.com.aeroparts.service.UsuarioService;
import br.com.aeroparts.entity.Usuario;
import br.com.aeroparts.service.mapper.UsuarioMapper;
import br.com.aeroparts.strategies.usuario.NomeUsuarioStrategy;
import br.com.aeroparts.strategies.usuario.UsuarioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //ESTRETEGY USUARIOS

    @GetMapping("/nome-ordenado")
    public ResponseEntity<List<UsuarioDTO>> listarUsuariosPorNome() {
        UsuarioStrategy strategy = new NomeUsuarioStrategy();
        List<UsuarioDTO> listarNomes = usuarioService.listaOrganizadaUsuarios(strategy).stream().map(UsuarioMapper::entityDTO).toList();
        return ResponseEntity.ok(listarNomes);
    }

    //CRUD USUARIOS

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
    public ResponseEntity<UsuarioDTO> criarNovoUsuario( @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.criarUsuario(UsuarioMapper.entity(usuarioDTO));
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizaUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioAtualizado = usuarioService.atualizaUsuario(id, UsuarioMapper.entity(usuarioDTO));
        return ResponseEntity.ok(UsuarioMapper.entityDTO(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
