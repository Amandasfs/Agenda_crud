package com.amanda.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Setter //Automatiza a criação de getters e setters.
@Getter
@Entity
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera id automaticamente.
    private int id;

    @NotEmpty(message = "Por favor, preencha todos os campos: informar o nome é obrigatório!")//mensagem de alerta para o usuario.
    @Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")//restrição de caracters, para não pesar o banco de dados.
    @Column(nullable = false) //coluna notNull.
    private String nome;

    @Column(nullable = false, updatable = false) //notNUll e inalteravel
    private LocalDateTime dataCadastro;

    public ClienteModel(String nome, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.dataCadastro = LocalDateTime.now(); // A data é gerada automaticamente pelo sistema
    }

}
