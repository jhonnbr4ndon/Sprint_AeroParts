package br.com.aeroparts.controller.thymeleaf;

import br.com.aeroparts.controller.dto.UsuarioDTO;
import br.com.aeroparts.entity.Usuario;
import br.com.aeroparts.service.UsuarioService;
import br.com.aeroparts.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuario")
public class UsuarioThymeleaf {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/novo")
    public String criarUsuario(@ModelAttribute UsuarioDTO usuarioDTO) {
        usuarioService.criarUsuario(UsuarioMapper.entity(usuarioDTO));
        return "redirect:/usuario";
    }

    @GetMapping("/novo")
    public String formularioNovoUsuario(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "/usuario/usuarioForm";
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarioDTO = usuarioService.listarUsuarios().stream().map(UsuarioMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "/usuario/usuario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.encontrarUsuarioPorID(id);
        model.addAttribute("usuarioDTO", UsuarioMapper.entityDTO(usuario));
        return "/usuario/usuarioEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(id);
        usuarioService.atualizarUsuario(usuarioDTO);
        return "redirect:/usuario";
    }

    @GetMapping("/delete/{id}")
    public String removerUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
        return "redirect:/usuario";
    }
}
