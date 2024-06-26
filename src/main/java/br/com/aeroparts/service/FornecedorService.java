package br.com.aeroparts.service;

import br.com.aeroparts.repository.FornecedorRepository;
import br.com.aeroparts.controller.dto.FornecedorDTO;
import br.com.aeroparts.entity.Fornecedor;
import br.com.aeroparts.strategies.fornecedor.FornecedorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorStrategy fornecedorStrategy;

    @Autowired
    private void setFornecedorStrategy(FornecedorStrategy fornecedorStrategy) {
        this.fornecedorStrategy = fornecedorStrategy;
    }

    public List<Fornecedor> listaOrganizadaForenecedor(FornecedorStrategy strategy) {
        List<Fornecedor> fornecedors = fornecedorRepository.findAll();
        return strategy.organizar(fornecedors);
    }

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor encontrarFornecedorPorID(Long id) {
        return fornecedorRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com o ID: " + id));
    }

    public Fornecedor atualizaFornecedor(Long id, Fornecedor fornecedorDTO) {
        Fornecedor fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com o ID: " + id));

        fornecedor.setNome(fornecedorDTO.getNome());
        fornecedor.setEndereco(fornecedorDTO.getEndereco());
        fornecedor.setContato(fornecedorDTO.getContato());

        return fornecedorRepository.save(fornecedor);
    }

    public void atualizarFornecedor(FornecedorDTO fornecedorDTO) {
        Optional<Fornecedor> optionalFornecedor = fornecedorRepository.findById(fornecedorDTO.getId());
        if (optionalFornecedor.isPresent()) {
            Fornecedor fornecedor = optionalFornecedor.get();
            fornecedor.setNome(fornecedorDTO.getNome());
            fornecedor.setEndereco(fornecedorDTO.getEndereco());
            fornecedor.setContato(fornecedorDTO.getContato());
            fornecedorRepository.save(fornecedor);
        } else {
            throw new RuntimeException("Fornecedor não encontrado com o ID: " + fornecedorDTO.getId());
        }
    }

    public void removerFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
