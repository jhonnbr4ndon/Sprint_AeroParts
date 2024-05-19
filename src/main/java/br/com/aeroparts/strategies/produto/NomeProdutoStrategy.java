package br.com.aeroparts.strategies.produto;

import br.com.aeroparts.entity.Produto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Component
public class NomeProdutoStrategy implements ProdutoStrategy {

    @Override
    public List<Produto> organizar(List<Produto> produtos) {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .collect(Collectors.toList());
    }
}
