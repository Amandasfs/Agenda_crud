package com.amanda.desafio.mapper;

import com.amanda.desafio.dto.ContatoDTO;
import com.amanda.desafio.model.ContatoModel;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    // metodo para converter model para dto
    public ContatoDTO toDTO(ContatoModel contato){
        if (contato == null) { //verifica se contato já existe
            return null;
        }
        ContatoDTO dto = new ContatoDTO();
        dto.setId(contato.getId());
        dto.setTexto(contato.getTexto());
        dto.setTipo(contato.getTipo());
        return dto;
    }

    // metodo para converter dto para model
    public ContatoModel toEntity(ContatoDTO dto) {
        if (dto == null) {
            return null;
        }
        ContatoModel contato= new ContatoModel();
        contato.setId(dto.getId());
        contato.setTexto(dto.getTexto());
        contato.setTipo(dto.getTipo());
        return contato;
    }
}
