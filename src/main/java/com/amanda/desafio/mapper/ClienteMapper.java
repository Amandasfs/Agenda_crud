package com.amanda.desafio.mapper;

import com.amanda.desafio.dto.ClienteDTO;
import com.amanda.desafio.dto.ContatoDTO;
import com.amanda.desafio.model.ClienteModel;
import com.amanda.desafio.model.ContatoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    @Autowired
    private ContatoMapper contatoMapper;

    // Converte ClienteModel para ClienteDTO
    public ClienteDTO toDTO(ClienteModel cliente) {
        if (cliente == null) {
            return null;
        }
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getContatos() == null ? null : cliente.getContatos()
                        .stream()
                        .map(contatoMapper::toDTO) // Converte cada ContatoModel para ContatoDTO
                        .collect(Collectors.toList())
        );
    }

    // Converte ClienteDTO para ClienteModel
    public ClienteModel toEntity(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }
        ClienteModel cliente = new ClienteModel();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());

        if (dto.getContatos() != null) {
            List<ContatoModel> contatos = dto.getContatos()
                    .stream()
                    .map(contatoDTO -> {
                        ContatoModel contato = contatoMapper.toEntity(contatoDTO);
                        contato.setCliente(cliente); // Define a relação bidirecional
                        return contato;
                    })
                    .collect(Collectors.toList());
            cliente.setContatos(contatos);
        }
        return cliente;
    }
}
