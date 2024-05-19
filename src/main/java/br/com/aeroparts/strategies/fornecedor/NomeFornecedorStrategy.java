package br.com.aeroparts.strategies.fornecedor;

import br.com.aeroparts.entity.Fornecedor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Component
public class NomeFornecedorStrategy implements FornecedorStrategy {

    @Override
    public List<Fornecedor> organizar(List<Fornecedor> fornecedors) {
        return fornecedors.stream()
                .sorted(Comparator.comparing(Fornecedor::getNome))
                .collect(Collectors.toList());

    }
}
