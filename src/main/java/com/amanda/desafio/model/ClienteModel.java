package com.amanda.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

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
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
