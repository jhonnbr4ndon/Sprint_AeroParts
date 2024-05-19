package br.com.aeroparts.service;

import br.com.aeroparts.repository.CotacaoRepository;
import br.com.aeroparts.controller.dto.CotacaoDTO;
import br.com.aeroparts.entity.Cotacao;
import br.com.aeroparts.strategies.cotacao.CotacaoEstrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    @Autowired
    private CotacaoEstrategy cotacaoEstrategy;

    @Autowired
    private void setCotacaoEstrategy(CotacaoEstrategy cotacaoEstrategy) {
        this.cotacaoEstrategy = cotacaoEstrategy;
    }

    public List<Cotacao> listaOrganizadaCotacao(CotacaoEstrategy strategy) {
        List<Cotacao> cotacao = cotacaoRepository.findAll();
        return strategy.organizar(cotacao);
    }

    public Cotacao criarCotacao(Cotacao cotacao) {
        return cotacaoRepository.save(cotacao);
    }

    public List<Cotacao> listarCotacoes() {
        return cotacaoRepository.findAll();
    }

    public Cotacao encontrarCotacaoPorID(Long id) {
        return cotacaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Cotação não encontrado com o ID: " + id));
    }

    public Cotacao atualizaCotacao(Long id, Cotacao cotacaoDTO) {
        Cotacao cotacao = cotacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada com o ID: " + id));

        cotacao.setData(cotacaoDTO.getData());
        cotacao.setPreco(cotacaoDTO.getPreco());

        return cotacaoRepository.save(cotacao);
    }

    public void atualizarCotacao(CotacaoDTO cotacaoDTO) {
        Optional<Cotacao> optionalCotacao = cotacaoRepository.findById(cotacaoDTO.getId());
        if (optionalCotacao.isPresent()) {
            Cotacao cotacao = optionalCotacao.get();
            cotacao.setData(cotacaoDTO.getData());
            cotacao.setPreco(cotacaoDTO.getPreco());
            cotacaoRepository.save(cotacao);
        } else {
            throw new RuntimeException("Cotação não encontrado com o ID: " + cotacaoDTO.getId());
        }
    }

    public void removerCotacao(Long id) {
        cotacaoRepository.deleteById(id);
    }
}
