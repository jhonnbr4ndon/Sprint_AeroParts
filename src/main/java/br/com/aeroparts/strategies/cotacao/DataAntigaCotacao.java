package br.com.aeroparts.strategies.cotacao;

import br.com.aeroparts.entity.Cotacao;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataAntigaCotacao implements CotacaoEstrategy {

    @Override
    public List<Cotacao> organizar(List<Cotacao> cotacao) {
        return cotacao.stream()
                .sorted(Comparator.comparing(Cotacao::getData))
                .collect(Collectors.toList());
    }
}
