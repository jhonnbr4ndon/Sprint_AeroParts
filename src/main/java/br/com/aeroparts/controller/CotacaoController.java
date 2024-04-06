package br.com.aeroparts.controller;

import br.com.aeroparts.controller.dto.CotacaoDTO;
import br.com.aeroparts.entity.Cotacao;
import br.com.aeroparts.service.CotacaoService;
import br.com.aeroparts.service.mapper.CotacaoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoService cotacaoService;

    @GetMapping("/lista")
    public ResponseEntity<List<CotacaoDTO>> listaCotacao() {
        List<CotacaoDTO> cotacaoDTO = cotacaoService.listarCotacoes().stream().map(CotacaoMapper::entityDTO).toList();
        return ResponseEntity.ok(cotacaoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CotacaoDTO> encontrarCotacaoPorID(@PathVariable Long id) {
        Cotacao cotacao = cotacaoService.encontrarCotacaoPorID(id);
        return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacao));
    }

    @PostMapping("/criar")
    public ResponseEntity<CotacaoDTO> criarNovaCotacao(@Valid @RequestBody CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = cotacaoService.criarCotacao(CotacaoMapper.entity(cotacaoDTO));
        return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CotacaoDTO> atualizarCotacao(@PathVariable Long id, @Valid @RequestBody CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = cotacaoService.atualizaCotacao(id, CotacaoMapper.entity(cotacaoDTO));
        return ResponseEntity.ok(CotacaoMapper.entityDTO(cotacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCotacao(@PathVariable Long id) {
        cotacaoService.removerCotacao(id);
        return ResponseEntity.noContent().build();
    }
}
