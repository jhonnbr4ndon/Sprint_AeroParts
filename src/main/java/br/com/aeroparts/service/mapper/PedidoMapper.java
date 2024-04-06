package br.com.aeroparts.service.mapper;

import br.com.aeroparts.controller.dto.PedidoDTO;
import br.com.aeroparts.entity.Pedido;

public class PedidoMapper {

    public static Pedido entity(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoDTO.getId());
        pedido.setData(pedidoDTO.getData());
        pedido.setStatus(pedidoDTO.getStatus());
        return pedido;
    }

    public static PedidoDTO entityDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setData(pedido.getData());
        pedidoDTO.setStatus(pedido.getStatus());
        return pedidoDTO;
    }
}
