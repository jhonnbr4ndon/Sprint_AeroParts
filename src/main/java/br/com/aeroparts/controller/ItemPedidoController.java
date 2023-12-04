package br.com.aeroparts.controller;

import br.com.aeroparts.entity.ItemPedido;
import br.com.aeroparts.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> obterItemPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.obterItemPedidoPorId(id).orElse(null));
    }

    @GetMapping
    public List<ItemPedido> mostrarItemPedido() {
        return itemPedidoService.mostrarItemPedido();
    }

    @PostMapping
    public ResponseEntity<String> criarItemPedido(@RequestBody ItemPedido itemPedido) {
        ItemPedido novoItemPedido = itemPedidoService.salvarItemPedido(itemPedido);
        return ResponseEntity.status(201).body("Item do pedido criado com sucesso. ID do ItemPedido: " + novoItemPedido.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedidoAtualizado) {
        Optional<ItemPedido> itemPedidoExistente = itemPedidoService.obterItemPedidoPorId(id);

        if (itemPedidoExistente.isPresent()) {
            ItemPedido itemPedido = itemPedidoExistente.get();
            itemPedido.setQuantidade(itemPedidoAtualizado.getQuantidade());

            itemPedidoService.salvarItemPedido(itemPedido);
            return ResponseEntity.ok("Item do pedido atualizado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarItemPedido(@PathVariable Long id) {
        itemPedidoService.deletarItemPedido(id);
        return ResponseEntity.ok("Item do pedido deletado com sucesso.");
    }
}
