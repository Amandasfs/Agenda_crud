package com.amanda.desafio.service;

import com.amanda.desafio.dto.ContatoDTO;
import com.amanda.desafio.model.ClienteModel;
import com.amanda.desafio.model.ContatoModel;
import com.amanda.desafio.repository.ContatoRepository;
import com.amanda.desafio.service.exceptions.DataIntegrityViolationException;
import com.amanda.desafio.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repos;//variável repos chama repositório.

    @Autowired
    private ClienteService clienteService;

    //busca contato por id
    public ContatoModel findById(Integer id) {
        Optional<ContatoModel> obj = repos.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Contato não encontrado! o id: " + id + ", Tipo: " + ClienteModel.class.getName()));
    }

    //busca e mostra contatos
    public List<ContatoModel>findAll(){
        return repos.findAll();
    }

    //cria contato
    public ContatoModel create(ContatoModel obj){
        ClienteModel cliente = clienteService.findById(obj.getCliente().getId()); //busca cliente a qual o contato pertence.
        obj.setCliente(cliente); // define o cliente no contato.
        return repos.save(obj);
    }

    //altera contato
    public ContatoModel update(Integer id, ContatoDTO objDto){
        ContatoModel obj = findById(id);
        obj.setTipo(objDto.getTipo());
        objDto.setTexto(objDto.getTexto());
        return repos.save(obj);
    }

    //deleta contato
    public void delete(Integer id) {
        findById(id);
        repos.deleteById(id); // busca por id e deleta objeto.
    }
}
