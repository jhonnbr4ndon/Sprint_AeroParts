package br.com.aeroparts.strategies.pedido;

import br.com.aeroparts.entity.Pedido;

import java.util.List;

public interface PedidoStrategy {

    List<Pedido> organizar(List<Pedido> pedidos);

}
