package com.amanda.desafio.dto;


import lombok.Getter;
import lombok.Setter;

@Setter //Automatiza a criação de getters e setters.
@Getter
public class ContatoDTO {
    private int id;
    private String tipo;
    private String texto;
    private ClienteDTO cliente; //chama dados do cliente

    public ContatoDTO() {
        //construtor vazio, padrão.
    }

    public ContatoDTO(int id, String tipo, String texto, ClienteDTO cliente) {
        this.id = id;
        this.tipo = tipo;
        this.texto = texto;
        this.cliente = cliente;
    }

}
