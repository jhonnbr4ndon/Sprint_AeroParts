package br.com.aeroparts.controller;

import br.com.aeroparts.entity.Fornecedor;
import br.com.aeroparts.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> obterFornecedorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.obterFornecedorPorId(id).orElse(null));
    }

    @GetMapping
    public List<Fornecedor> mostrarFornecedores() {
        return fornecedorService.mostrarFornecedor();
    }

    @PostMapping
    public ResponseEntity<String> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor novoFornecedor = fornecedorService.salvarFornecedor(fornecedor);
        return ResponseEntity.status(201).body("Fornecedor criado com sucesso. ID do Fornecedor: " + novoFornecedor.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedorAtualizado) {
        Optional<Fornecedor> fornecedorExistente = fornecedorService.obterFornecedorPorId(id);

        if (fornecedorExistente.isPresent()) {
            Fornecedor fornecedor = fornecedorExistente.get();
            fornecedor.setNome(fornecedorAtualizado.getNome());
            fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
            fornecedor.setContato(fornecedorAtualizado.getContato());

            fornecedorService.salvarFornecedor(fornecedor);
            return ResponseEntity.ok("Fornecedor atualizado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.ok("Fornecedor deletado com sucesso.");
    }

}
