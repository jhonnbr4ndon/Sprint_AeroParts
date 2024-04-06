package br.com.aeroparts.controller.thymeleaf;

import br.com.aeroparts.controller.dto.PedidoDTO;
import br.com.aeroparts.entity.Pedido;
import br.com.aeroparts.service.PedidoService;
import br.com.aeroparts.service.mapper.PedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pedido")
public class PedidoThymeleaf {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/novo")
    public String criarPedido(@ModelAttribute PedidoDTO pedidoDTO) {
        pedidoService.criarPedido(PedidoMapper.entity(pedidoDTO));
        return "redirect:/pedido";
    }

    @GetMapping("/novo")
    public String formularioNovoPedido(Model model) {
        model.addAttribute("pedidoDTO", new PedidoDTO());
        return "/pedido/pedidoForm";
    }

    @GetMapping
    public String listarPedidos(Model model) {
        List<PedidoDTO> pedidoDTO = pedidoService.listarPedido().stream().map(PedidoMapper::entityDTO).collect(Collectors.toList());
        model.addAttribute("pedidoDTO", pedidoDTO);
        return "/pedido/pedido";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.encontrarPedidoPorID(id);
        model.addAttribute("pedidoDTO", PedidoMapper.entityDTO(pedido));
        return "/pedido/pedidoEditar";
    }

    @PostMapping("/update/{id}")
    public String atualizarPedido(@PathVariable Long id, @ModelAttribute PedidoDTO pedidoDTO) {
        pedidoDTO.setId(id);
        pedidoService.atualizarPedidos(pedidoDTO);
        return "redirect:/pedido";
    }

    @GetMapping("/delete/{id}")
    public String removerPedido(@PathVariable Long id) {
        pedidoService.removerPedido(id);
        return "redirect:/pedido";
    }
}
