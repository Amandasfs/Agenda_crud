package com.amanda.desafio.dto;

import com.amanda.desafio.model.ClienteModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter //Automatiza a criação de getters e setters.
@Getter
@NoArgsConstructor
public class ClienteDTO {

    private int id;
    private String nome;
    private LocalDateTime dataCadastro;
    private List<ContatoDTO> contatos; //lista de contatos.

    public ClienteDTO(int id, String nome, LocalDateTime dataCadastro, List<ContatoDTO> contatos) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.contatos = contatos;
    }
}
