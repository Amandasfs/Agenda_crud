package com.amanda.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter //automatiza a criação de getters e setters.
@Setter
@NoArgsConstructor//construtor padrão.
@Entity
public class ContatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Por favor, preencha todos os campos: informar o tipo de contato é obrigatório!") //mensagem de alerta para o usuario.
    @Length(min = 3, max = 100, message = "O tipo de contato deve ter entre 3 e 100 caracteres.")//restrição de caracters, para não pesar o banco de dados.
    @Column(nullable = false) //não pode ser vazio
    private String tipo;

    @Length(min = 100, max = 350, message = "O texto deve ter entre 100 e 350 caracteres.")
    @Column(nullable = true) //pode ser vazio, podendo ser adicionado depois
    private String texto;

    @ManyToOne //define que são muitos contatos para um
    @JoinColumn(name = "cliente_id", nullable = false)//define id do cliente como foreign key
    private ClienteModel cliente;

    public ContatoModel(String tipo, String texto, ClienteModel cliente) {
        this.tipo = tipo;
        this.texto = texto;
        this.cliente = cliente;
    }
}
