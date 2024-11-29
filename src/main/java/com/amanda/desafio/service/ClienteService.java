package com.amanda.desafio.service;

import com.amanda.desafio.model.ClienteModel;
import com.amanda.desafio.model.ContatoModel;
import com.amanda.desafio.repository.ClienteRepository;
import com.amanda.desafio.service.exceptions.DataIntegrityViolationException;
import com.amanda.desafio.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repos; //variável repos chama repositório.

    @Autowired
    private ContatoService contato; //variável contato chama classes de contato service.

    //metodo de buscar cliente por id
    public ClienteModel findById(Integer id) {
        //usa o repositorio para encontrar o cliente, e retorna opcional.
        Optional<ClienteModel> obj = repos.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! o id: " + id + ", Tipo: " + ClienteModel.class.getName())); // se não encontrar o cliente, a classe retorna mensagem de erro.
    }

    //metodo para atualiza cliente.
    public ClienteModel update(Integer id, ClienteModel obj){
        ClienteModel newObj = findById(id);
        updateData(newObj, obj); //chama metodo de alteração
        return repos.save(newObj);
    }

    //metodo de altera nome.
    private void updateData(ClienteModel newObj, ClienteModel obj){
        newObj.setNome(obj.getNome()); //altera somente o nome
    }

    //metodo de cadastro.
    public ClienteModel create(ClienteModel obj){
        obj.setId(null);//responsavel por garantir que seja um novo cleinte
        return repos.save(obj);//salva o cliente diretamente
    }
    //metodo para deletar cliente
    public void delete(Integer id){
        findById(id);
        try{
            repos.deleteById(id);
        }catch (org.springframework.dao.DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Esse cliente não pode ser deletado, pois possui contatos cadastrados");
        }
    }

}
