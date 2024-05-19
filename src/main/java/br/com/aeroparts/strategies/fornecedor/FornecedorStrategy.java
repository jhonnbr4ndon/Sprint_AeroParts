package br.com.aeroparts.strategies.fornecedor;

import br.com.aeroparts.entity.Fornecedor;

import java.util.List;

public interface FornecedorStrategy {

    List<Fornecedor> organizar(List<Fornecedor> fornecedors);

}
