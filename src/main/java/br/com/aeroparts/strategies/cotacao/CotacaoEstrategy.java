package br.com.aeroparts.strategies.cotacao;

import br.com.aeroparts.entity.Cotacao;

import java.util.List;

public interface CotacaoEstrategy {

    List<Cotacao> organizar(List<Cotacao> cotacao);

}
