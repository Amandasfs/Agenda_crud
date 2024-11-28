package com.amanda.desafio.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter //Automatiza a criação de getters e setters.
@Getter
public class ClienteDTO {

    private int id;
    private String nome;
    private LocalDateTime dataCadastro;

    public ClienteDTO() {
        //construtor vazio, padrão.
    }

    public ClienteDTO(int id, String nome, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }
}
