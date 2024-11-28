package com.amanda.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter //Automatiza a criação de getters e setters.
@Setter//Automatiza a criação de getters e setters.
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

}
