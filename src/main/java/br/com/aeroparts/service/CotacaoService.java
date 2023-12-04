package br.com.aeroparts.service;

import br.com.aeroparts.entity.Cotacao;
import br.com.aeroparts.repository.CotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotacaoService {

    @Autowired
    private CotacaoRepository cotacaoRepository;

    public Optional<Cotacao> obterCotacaoPorId(Long id) {
        return cotacaoRepository.findById(id);
    }

    public List<Cotacao> mostrarCotacoes() {
        return cotacaoRepository.findAll();
    }

    public Cotacao salvarCotacao(Cotacao cotacao) {
        return cotacaoRepository.save(cotacao);
    }

    public void deletarCotacao(Long id) {
        cotacaoRepository.deleteById(id);
    }
}