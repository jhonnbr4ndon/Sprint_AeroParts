package br.com.aeroparts.controller.thymeleaf;

import br.com.aeroparts.controller.dto.ItemPedidoDTO;
import br.com.aeroparts.entity.ItemPedido;
import br.com.aeroparts.service.ItemPedidoService;
import br.com.aeroparts.service.mapper.ItemPedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/itempedido")
public class ItemPedidoThymeleaf {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping("/novo")
    public String criarItemPedido(@ModelAttribute ItemPedidoDTO itemPedidoDTO) {
        itemPedidoService.criarItemPedido(ItemPedidoMapper.entity(itemPedidoDTO));
        return "redirect:/itempedido";
    }

    @GetMapping("/novo")
    public String formularioNovoItemPedido(Model model) {
        model.addAttribute("itempedidoDTO", new ItemPedidoDTO());
        return "/itempedido/itempedidoForm";
    }

    @GetMapping
    public String listarItemPedidos(Model model) {
        List<ItemPedidoDTO> itemPedidoDTO = itemPedidoService.listarItemPedido().stream().map(ItemPedidoMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("itempedidoDTO", itemPedidoDTO);
        return "/itempedido/itempedido";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarItemPedido(@PathVariable Long id, Model model) {
        ItemPedido itemPedido = itemPedidoService.encontrarItemPedidoPorID(id);
        model.addAttribute("itempedidoDTO", ItemPedidoMapper.entityDTO(itemPedido));
        return "/itempedido/itempedidoEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarItemPedido(@PathVariable Long id, @ModelAttribute ItemPedidoDTO itemPedidoDTO) {
        itemPedidoDTO.setId(id);
        itemPedidoService.atualizarItemPedido(itemPedidoDTO);
        return "redirect:/itempedido";
    }

    @GetMapping("/delete/{id}")
    public String removerItemPedido(@PathVariable Long id) {
        itemPedidoService.removerItemPedido(id);
        return "redirect:/itempedido";
    }
}
