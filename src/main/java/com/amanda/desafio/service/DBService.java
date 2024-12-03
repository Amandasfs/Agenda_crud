package com.amanda.desafio.service;

import com.amanda.desafio.model.ClienteModel;
import com.amanda.desafio.model.ContatoModel;
import com.amanda.desafio.repository.ClienteRepository;
import com.amanda.desafio.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepos;

    @Autowired
    private ContatoRepository contatoRepos;

    public void instantiateDatabase() { //testa inserção de dados
        // Criando clientes
        ClienteModel cliente1 = new ClienteModel("Amanda Silva", null);
        ClienteModel cliente2 = new ClienteModel("João Souza", null);

        // Criando contatos
        ContatoModel contato1 = new ContatoModel("Email", "amanda@example.com", cliente1);
        ContatoModel contato2 = new ContatoModel("Telefone", "123456789", cliente1);
        ContatoModel contato3 = new ContatoModel("Email", "joao@example.com", cliente2);

        // Configurando a relação bidirecional
        cliente1.setContatos(Arrays.asList(contato1, contato2));
        cliente2.setContatos(Arrays.asList(contato3));

        // Salvando no repositório
        clienteRepos.saveAll(Arrays.asList(cliente1, cliente2));
        contatoRepos.saveAll(Arrays.asList(contato1, contato2, contato3));
    }
}
