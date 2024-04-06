package br.com.aeroparts.controller;

import br.com.aeroparts.controller.dto.PedidoDTO;
import br.com.aeroparts.entity.Pedido;
import br.com.aeroparts.service.PedidoService;
import br.com.aeroparts.service.mapper.PedidoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/lista")
    public ResponseEntity<List<PedidoDTO>> listaPedidos() {
        List<PedidoDTO> pedidoDTO = pedidoService.listarPedido().stream().map(PedidoMapper::entityDTO).toList();
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> encontrarPedidoPorID(@PathVariable Long id) {
        Pedido pedido = pedidoService.encontrarPedidoPorID(id);
        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
    }

    @PostMapping("/criar")
    public ResponseEntity<PedidoDTO> criarNovoPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.criarPedido(PedidoMapper.entity(pedidoDTO));
        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizaPedido(@PathVariable Long id, @Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.atualizaPedido(id, PedidoMapper.entity(pedidoDTO));
        return ResponseEntity.ok(PedidoMapper.entityDTO(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        pedidoService.removerPedido(id);
        return ResponseEntity.noContent().build();
    }
}
