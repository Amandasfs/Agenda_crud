package com.amanda.desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Setter //automatiza a criação de getters e setters.
@Getter
@NoArgsConstructor //construtor padrão.
@Entity //define como entidade.
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera id automaticamente.
    private Integer id;

    @NotEmpty(message = "Por favor, preencha todos os campos: informar o nome é obrigatório!")//mensagem de alerta para o usuario.
    @Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")//restrição de caracters, para não pesar o banco de dados.
    @Column(nullable = false) //coluna notNull.
    private String nome;

    @Column(nullable = false, updatable = false) //notNUll e inalteravel
    private LocalDateTime dataCadastro;

    //define relação de um para muitos, porque um cliente pode ter 1 ou n contatos, mas 1 contato pertence a 1 cliente.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)//cascade usado para quando o usuario usar o crud no sistema, o que for feito no cliente também serão feitas em contato.
    private List<ContatoModel> contatos; //associa contatos aos clientes.

    public ClienteModel(String nome, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.dataCadastro = LocalDateTime.now(); // A data é gerada automaticamente pelo sistema
    }

}
