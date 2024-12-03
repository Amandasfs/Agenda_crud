package com.amanda.desafio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter //Automatiza a criação de getters e setters.
@Getter
@NoArgsConstructor
public class ClienteDTO {

    private int id;
    private String nome;
    private List<ContatoDTO> contatos; //lista de contatos.

    public ClienteDTO(int id, String nome, List<ContatoDTO> contatos) {
        this.id = id;
        this.nome = nome;
        this.contatos = contatos;
    }
}
