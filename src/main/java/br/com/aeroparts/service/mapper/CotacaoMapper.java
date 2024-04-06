package br.com.aeroparts.service.mapper;

import br.com.aeroparts.controller.dto.CotacaoDTO;
import br.com.aeroparts.entity.Cotacao;

public class CotacaoMapper {
    public static Cotacao entity(CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = new Cotacao();
        cotacao.setId(cotacaoDTO.getId());
        cotacao.setData(cotacaoDTO.getData());
        cotacao.setPreco(cotacaoDTO.getPreco());
        return cotacao;
    }

    public static CotacaoDTO entityDTO(Cotacao cotacao) {
        CotacaoDTO cotacaoDTO = new CotacaoDTO();
        cotacaoDTO.setId(cotacao.getId());
        cotacaoDTO.setData(cotacao.getData());
        cotacaoDTO.setPreco(cotacao.getPreco());
        return cotacaoDTO;
    }
}
