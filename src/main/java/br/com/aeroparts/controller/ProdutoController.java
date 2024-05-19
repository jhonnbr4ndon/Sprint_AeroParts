package br.com.aeroparts.controller;

import br.com.aeroparts.controller.dto.ProdutoDTO;
import br.com.aeroparts.entity.Produto;
import br.com.aeroparts.service.ProdutoService;
import br.com.aeroparts.service.mapper.ProdutoMapper;
import br.com.aeroparts.strategies.produto.NomeProdutoStrategy;
import br.com.aeroparts.strategies.produto.PrecoMaiorStrategy;
import br.com.aeroparts.strategies.produto.PrecoMenorStrategy;
import br.com.aeroparts.strategies.produto.ProdutoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    //STRATEGIES PRODUTOS

    @GetMapping("/nome-ordenado")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosPorNome() {
        ProdutoStrategy strategy = new NomeProdutoStrategy();
        List<ProdutoDTO> listarNomes = produtoService.listaOrganizadaProdutos(strategy).stream().map(ProdutoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarNomes);
    }

    @GetMapping("/preco-menor")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosPorPrecoMenor() {
        ProdutoStrategy strategy = new PrecoMenorStrategy();
        List<ProdutoDTO> listarPreco = produtoService.listaOrganizadaProdutos(strategy).stream().map(ProdutoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarPreco);
    }

    @GetMapping("/preco-maior")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosPorPrecoMaior() {
        ProdutoStrategy strategy = new PrecoMaiorStrategy();
        List<ProdutoDTO> listarPreco = produtoService.listaOrganizadaProdutos(strategy).stream().map(ProdutoMapper::entityDTO).toList();
        return ResponseEntity.ok(listarPreco);
    }

    //CRUD PRODUTOS

    @GetMapping("/lista")
    public ResponseEntity<List<ProdutoDTO>> listaProdutos() {
        List<ProdutoDTO> produtoDTO = produtoService.listarProdutos().stream().map(ProdutoMapper::entityDTO).toList();
        return ResponseEntity.ok(produtoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> encontrarProdutoPorID(@PathVariable Long id) {
        Produto produto = produtoService.encontrarProdutoPorID(id);
        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
    }

    @PostMapping("/criar")
    public ResponseEntity<ProdutoDTO> criarNovoProduto( @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.criarProduto(ProdutoMapper.entity(produtoDTO));
        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizaProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produtoAtualizado = produtoService.atualizaProduto(id, ProdutoMapper.entity(produtoDTO));
        return ResponseEntity.ok(ProdutoMapper.entityDTO(produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.removerProduto(id);
        return ResponseEntity.noContent().build();
    }
}
