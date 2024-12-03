package com.amanda.desafio.mapper;

import com.amanda.desafio.dto.ContatoDTO;
import com.amanda.desafio.model.ClienteModel;
import com.amanda.desafio.model.ContatoModel;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    // Converte ContatoModel para ContatoDTO
    public ContatoDTO toDTO(ContatoModel contato) {
        if (contato == null) {
            return null;
        }
        return new ContatoDTO(
                contato.getId(),
                contato.getTipo(),
                contato.getTexto(),
                contato.getCliente() != null ? contato.getCliente().getId() : 0 // Adiciona o clienteId
        );
    }

    // Converte ContatoDTO para ContatoModel
    public ContatoModel toEntity(ContatoDTO dto) {
        if (dto == null) {
            return null;
        }
        ContatoModel contato = new ContatoModel();
        contato.setId(dto.getId());
        contato.setTipo(dto.getTipo());
        contato.setTexto(dto.getTexto());

        if (dto.getClienteId() > 0) {
            ClienteModel cliente = new ClienteModel();
            cliente.setId(dto.getClienteId()); // Apenas associa o ID do cliente
            contato.setCliente(cliente);
        }
        return contato;
    }
}
