package br.com.aeroparts.service;

import br.com.aeroparts.entity.Produto;
import br.com.aeroparts.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<Produto> obterProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> mostrarProduto() {
        return produtoRepository.findAll();
    }
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
