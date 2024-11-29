package com.amanda.desafio.mapper;

import com.amanda.desafio.dto.ClienteDTO;
import com.amanda.desafio.model.ClienteModel;

public class ClienteMapper {
    // metodo para converter model para dto
    public ClienteDTO toDTO(ClienteModel cliente) {
        if (cliente == null) {//verifica se contato já existe
            return null;
        }
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setDataCadastro(cliente.getDataCadastro());
        return dto;
    }

    // metodo para converter dto para model
    public ClienteModel toEntity(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }
        ClienteModel cliente = new ClienteModel();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setDataCadastro(dto.getDataCadastro());
        return cliente;
    }
}
