package br.com.aeroparts.strategies.pedido;

import br.com.aeroparts.entity.Pedido;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Component
public class DataRecenteStrategy implements PedidoStrategy {

    @Override
    public List<Pedido> organizar(List<Pedido> pedidos) {
        return pedidos.stream()
                .sorted(Comparator.comparing(Pedido::getData).reversed())
                .collect(Collectors.toList());
    }

}
