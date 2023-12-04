package br.com.aeroparts.repository;

import br.com.aeroparts.entity.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
}
