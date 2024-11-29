package com.amanda.desafio.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter //Automatiza a criação de getters e setters.
@Getter
@NoArgsConstructor
public class ContatoDTO {
    private int id;
    private String tipo;
    private String texto;
    private int clienteId; //ID do cliente.

    public ContatoDTO(int id, String tipo, String texto, int clienteId) {
        this.id = id;
        this.tipo = tipo;
        this.texto = texto;
        this.clienteId = clienteId;
    }

}
