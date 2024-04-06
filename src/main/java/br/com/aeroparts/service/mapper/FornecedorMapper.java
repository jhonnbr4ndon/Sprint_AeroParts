package br.com.aeroparts.service.mapper;

import br.com.aeroparts.controller.dto.FornecedorDTO;
import br.com.aeroparts.entity.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor entity(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(fornecedorDTO.getId());
        fornecedor.setNome(fornecedorDTO.getNome());
        fornecedor.setEndereco(fornecedorDTO.getEndereco());
        fornecedor.setContato(fornecedorDTO.getContato());
        return fornecedor;
    }

    public static FornecedorDTO entityDTO(Fornecedor fornecedor) {
        FornecedorDTO fornecedorDTO = new FornecedorDTO();
        fornecedorDTO.setId(fornecedor.getId());
        fornecedorDTO.setNome(fornecedor.getNome());
        fornecedorDTO.setEndereco(fornecedor.getEndereco());
        fornecedorDTO.setContato(fornecedor.getContato());
        return fornecedorDTO;
    }
}
