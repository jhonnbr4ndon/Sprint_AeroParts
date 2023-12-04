package br.com.aeroparts.controller;

import br.com.aeroparts.entity.Produto;
import br.com.aeroparts.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.obterProdutoPorId(id).orElse(null));
    }

    @GetMapping
    public List<Produto> mostrarProdutos() {
        return produtoService.mostrarProduto();
    }

    @PostMapping
    public ResponseEntity<String> criarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvarProduto(produto);
        return ResponseEntity.status(201).body("Produto criado com sucesso. ID do Produto: " + novoProduto.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoService.obterProdutoPorId(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());

            produtoService.salvarProduto(produto);
            return ResponseEntity.ok("Produto atualizado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.ok("Produto deletado com sucesso.");
    }
}
