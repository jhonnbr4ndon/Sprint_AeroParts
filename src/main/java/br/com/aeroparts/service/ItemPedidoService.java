package br.com.aeroparts.service;

import br.com.aeroparts.entity.ItemPedido;
import br.com.aeroparts.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Optional<ItemPedido> obterItemPedidoPorId(Long id) {
        return itemPedidoRepository.findById(id);
    }

    public List<ItemPedido> mostrarItemPedido() {
        return itemPedidoRepository.findAll();
    }
    public ItemPedido salvarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public void deletarItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
