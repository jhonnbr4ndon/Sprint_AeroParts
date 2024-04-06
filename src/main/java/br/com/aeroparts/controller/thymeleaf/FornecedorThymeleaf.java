package br.com.aeroparts.controller.thymeleaf;

import br.com.aeroparts.controller.dto.FornecedorDTO;
import br.com.aeroparts.entity.Fornecedor;
import br.com.aeroparts.service.FornecedorService;
import br.com.aeroparts.service.mapper.FornecedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorThymeleaf {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping("/novo")
    public String criarFornecedor(@ModelAttribute FornecedorDTO fornecedorDTO) {
        fornecedorService.criarFornecedor(FornecedorMapper.entity(fornecedorDTO));
        return "redirect:/fornecedor";
    }

    @GetMapping("/novo")
    public String formularioNovoFornecedor(Model model) {
        model.addAttribute("fornecedorDTO", new FornecedorDTO());
        return "/fornecedor/fornecedorForm";
    }

    @GetMapping
    public String listarFornecedores(Model model) {
        List<FornecedorDTO> fornecedorDTO = fornecedorService.listarFornecedores().stream().map(FornecedorMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("fornecedorDTO", fornecedorDTO);
        return "/fornecedor/fornecedor";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarFornecedor(@PathVariable Long id, Model model) {
        Fornecedor fornecedor = fornecedorService.encontrarFornecedorPorID(id);
        model.addAttribute("fornecedorDTO", FornecedorMapper.entityDTO(fornecedor));
        return "/fornecedor/fornecedorEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarFornecedor(@PathVariable Long id, @ModelAttribute FornecedorDTO fornecedorDTO) {
        fornecedorDTO.setId(id);
        fornecedorService.atualizarFornecedor(fornecedorDTO);
        return "redirect:/fornecedor";
    }

    @GetMapping("/delete/{id}")
    public String removerFornecedor(@PathVariable Long id) {
        fornecedorService.removerFornecedor(id);
        return "redirect:/fornecedor";
    }
}
