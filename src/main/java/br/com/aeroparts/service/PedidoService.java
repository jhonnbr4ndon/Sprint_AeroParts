package br.com.aeroparts.service;

import br.com.aeroparts.controller.dto.PedidoDTO;
import br.com.aeroparts.entity.Pedido;
import br.com.aeroparts.repository.PedidoRepository;
import br.com.aeroparts.strategies.pedido.PedidoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoStrategy pedidoStrategy;

    @Autowired
    public void setPedidoStrategy(PedidoStrategy pedidoStrategy) {
        this.pedidoStrategy = pedidoStrategy;
    }

    public List<Pedido> listaOrganizadaPedido(PedidoStrategy strategy) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return strategy.organizar(pedidos);
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedido() {
        return pedidoRepository.findAll();
    }

    public Pedido encontrarPedidoPorID(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));
    }

    public Pedido atualizaPedido(Long id, Pedido pedidoDTO) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));

        pedido.setData(pedidoDTO.getData());
        pedido.setStatus(pedidoDTO.getStatus());

        return pedidoRepository.save(pedido);
    }

    public void atualizarPedidos(PedidoDTO pedidoDTO) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(pedidoDTO.getId());
        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            pedido.setData(pedidoDTO.getData());
            pedido.setStatus(pedidoDTO.getStatus());
            pedidoRepository.save(pedido);
        } else {
            throw new RuntimeException("Pedido não encontrado com o ID: " + pedidoDTO.getId());
        }
    }

    public void removerPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
