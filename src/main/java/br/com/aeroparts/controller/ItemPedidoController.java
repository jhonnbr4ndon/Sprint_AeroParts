package br.com.aeroparts.controller;

import br.com.aeroparts.controller.dto.ItemPedidoDTO;
import br.com.aeroparts.entity.ItemPedido;
import br.com.aeroparts.service.ItemPedidoService;
import br.com.aeroparts.service.mapper.ItemPedidoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping("/lista")
    public ResponseEntity<List<ItemPedidoDTO>> listaItemPedido() {
        List<ItemPedidoDTO> itemPedidoDTO = itemPedidoService.listarItemPedido().stream().map(ItemPedidoMapper::entityDTO).toList();
        return ResponseEntity.ok(itemPedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> encontrarItemPedidoPorID(@PathVariable Long id) {
        ItemPedido itemPedido = itemPedidoService.encontrarItemPedidoPorID(id);
        return ResponseEntity.ok(ItemPedidoMapper.entityDTO(itemPedido));
    }

    @PostMapping("/criar")
    public ResponseEntity<ItemPedidoDTO> criarNovoItemPedido(@Valid @RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = itemPedidoService.criarItemPedido(ItemPedidoMapper.entity(itemPedidoDTO));
        return ResponseEntity.ok(ItemPedidoMapper.entityDTO(itemPedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoDTO> atualizarItemPedido(@PathVariable Long id, @Valid @RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = itemPedidoService.atualizaItemPedido(id, ItemPedidoMapper.entity(itemPedidoDTO));
        return ResponseEntity.ok(ItemPedidoMapper.entityDTO(itemPedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemPedido(@PathVariable Long id) {
        itemPedidoService.removerItemPedido(id);
        return ResponseEntity.noContent().build();
    }
}
