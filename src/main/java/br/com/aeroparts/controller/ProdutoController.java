package br.com.aeroparts.controller;

import br.com.aeroparts.controller.dto.ProdutoDTO;
import br.com.aeroparts.entity.Produto;
import br.com.aeroparts.service.ProdutoService;
import br.com.aeroparts.service.mapper.ProdutoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

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
    public ResponseEntity<ProdutoDTO> criarNovoProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.criarProduto(ProdutoMapper.entity(produtoDTO));
        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizaProduto(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.atualizaProduto(id, ProdutoMapper.entity(produtoDTO));
        return ResponseEntity.ok(ProdutoMapper.entityDTO(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.removerProduto(id);
        return ResponseEntity.noContent().build();
    }
}
