package com.amanda.desafio.service;

import com.amanda.desafio.dto.ContatoDTO;
import com.amanda.desafio.mapper.ContatoMapper;
import com.amanda.desafio.model.ClienteModel;
import com.amanda.desafio.model.ContatoModel;
import com.amanda.desafio.repository.ClienteRepository;
import com.amanda.desafio.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    @Autowired
    private ClienteRepository clienteRepos;

    @Autowired
    private ContatoMapper mapper;

    //cria contato
    public ContatoDTO createContato(ContatoDTO dto){
        ClienteModel cliente = clienteRepos.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não existe")); //busca cliente pelo id
        ContatoModel model = mapper.toEntity(dto); //converte de dto para model.
        model.setCliente(cliente); //associa cliente com contato
        model = repository.save(model); //salva no banco
        return mapper.toDTO(model); //converte de model para dto, novamente.
    }

    //busca contatos
    public List<ContatoDTO> getContatosByClienteId(Integer clienteId){
        List<ContatoModel> contatos = repository.findAllByClienteId(clienteId); //chama dados dos contatos
        return contatos.stream()//usa stream para converter a lista de model para dto
                .map(mapper::toDTO)//converte cada objeto da lista separadamente
                .collect(Collectors.toList());//usa os resultados da conversão para criar uma nova lista.
    }

    //atualiza contato
    public ContatoDTO updateContato(Integer id, ContatoDTO dto){
        if (!repository.existsById(id)){
            throw new RuntimeException("Contato não encontrado"); //verifica se contato existe
        }
        ContatoModel model = mapper.toEntity(dto); //converte dto para model
        model.setId(id);//chama cliente referente ao id buscado
        model = repository.save(model);//salva no banco
        return mapper.toDTO(model);//converte de model para dto novamente.
    }

    //deletar contato
    public void deleteContato(Integer id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Contato não encontrado!");//verifica se cliente existe, se o id não estiver no repositorio ele aparece a mensagem de erro.
        }
        repository.deleteById(id);//deleta contato.
    }
}
