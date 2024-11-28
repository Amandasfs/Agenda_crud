package com.amanda.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
public class ContatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Por favor, preencha todos os campos: informar o tipo de contato é obrigatório!") //mensagem de alerta para o usuario.
    @Length(min = 3, max = 100, message = "O tipo de contato deve ter entre 3 e 100 caracteres.")//restrição de caracters, para não pesar o banco de dados.
    @Column(nullable = false) //não pode ser vazio
    private String tipo;

    @Length(min = 100, max = 350, message = "O texto deve ter entre 100 e 350 caracteres.")
    @Column(nullable = true) //pode ser vazio, podendo ser adicionado depois
    private String texto;

    public ContatoModel(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
