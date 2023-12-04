package br.com.aeroparts.controller;

import br.com.aeroparts.entity.Pedido;
import br.com.aeroparts.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obterPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obterPedidoPorId(id).orElse(null));
    }

    @GetMapping
    public List<Pedido> mostrarPedido() {
        return pedidoService.mostrarPedido();
    }

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.salvarPedido(pedido);
        return ResponseEntity.status(201).body("Pedido criado com sucesso. ID do Pedido: " + novoPedido.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        Optional<Pedido> pedidoExistente = pedidoService.obterPedidoPorId(id);

        if (pedidoExistente.isPresent()) {
            Pedido pedido = pedidoExistente.get();
            pedido.setData(pedidoAtualizado.getData());
            pedido.setStatus(pedidoAtualizado.getStatus());

            pedidoService.salvarPedido(pedido);
            return ResponseEntity.ok("Pedido atualizado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.ok("Pedido deletado com sucesso.");
    }
}
