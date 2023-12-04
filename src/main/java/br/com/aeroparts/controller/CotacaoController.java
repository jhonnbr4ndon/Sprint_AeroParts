package br.com.aeroparts.controller;

import br.com.aeroparts.entity.Cotacao;
import br.com.aeroparts.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Cotacao> obterCotacaoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cotacaoService.obterCotacaoPorId(id).orElse(null));
    }

    @GetMapping
    public List<Cotacao> mostrarCotacoes() {
        return cotacaoService.mostrarCotacoes();
    }

    @PostMapping
    public ResponseEntity<String> criarCotacao(@RequestBody Cotacao cotacao) {
        Cotacao novaCotacao = cotacaoService.salvarCotacao(cotacao);
        return ResponseEntity.status(201).body("Cotacao criada com sucesso. ID da Cotacao: " + novaCotacao.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCotacao(@PathVariable Long id, @RequestBody Cotacao cotacaoAtualizado) {
        Optional<Cotacao> cotacaoExistente = cotacaoService.obterCotacaoPorId(id);

        if (cotacaoExistente.isPresent()) {
            Cotacao cotacao = cotacaoExistente.get();
            cotacao.setData(cotacaoAtualizado.getData());
            cotacao.setPreco(cotacaoAtualizado.getPreco());

            cotacaoService.salvarCotacao(cotacao);
            return ResponseEntity.ok("Cotacao atualizada com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCotacao(@PathVariable Long id) {
        cotacaoService.deletarCotacao(id);
        return ResponseEntity.ok("Cotacao deletada com sucesso.");
    }

}
