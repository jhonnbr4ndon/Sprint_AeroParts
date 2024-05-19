package br.com.aeroparts.service;

import br.com.aeroparts.controller.dto.ProdutoDTO;
import br.com.aeroparts.entity.Produto;
import br.com.aeroparts.repository.ProdutoRepository;
import br.com.aeroparts.strategies.produto.ProdutoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoStrategy produtoStrategy;

    @Autowired
    public void setProdutoStrategy(ProdutoStrategy produtoStrategy) {
        this.produtoStrategy = produtoStrategy;
    }

    public List<Produto> listaOrganizadaProdutos(ProdutoStrategy strategy) {
        List<Produto> produtos = produtoRepository.findAll();
        return strategy.organizar(produtos);
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto encontrarProdutoPorID(Long id) {
        return produtoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    public Produto atualizaProduto(Long id, Produto produtoDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));

        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());

        return produtoRepository.save(produto);
    }

    public void atualizarProduto(ProdutoDTO produtoDTO) {
        Optional<Produto> optionalProduto = produtoRepository.findById(produtoDTO.getId());
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNome(produtoDTO.getNome());
            produto.setDescricao(produtoDTO.getDescricao());
            produto.setPreco(produtoDTO.getPreco());
            produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado com o ID: " + produtoDTO.getId());
        }
    }

    public void removerProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
