package br.com.aeroparts.strategies.produto;

import br.com.aeroparts.entity.Produto;

import java.util.List;

public interface ProdutoStrategy {

    List<Produto> organizar(List<Produto> produtos);

}
