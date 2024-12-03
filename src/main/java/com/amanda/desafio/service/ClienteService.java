package com.amanda.desafio.service;

import com.amanda.desafio.dto.ClienteDTO;
import com.amanda.desafio.mapper.ClienteMapper;
import com.amanda.desafio.model.ClienteModel;
import com.amanda.desafio.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;//chama o repositorio do cliente.

    @Autowired
    private ClienteMapper mapper;//chama mapper.

    //cadastrar cliente
    @Transactional
    public ClienteDTO createCliente(ClienteDTO dto) {
        ClienteModel model = mapper.toEntity(dto);
        model = repository.save(model);
        return mapper.toDTO(model);
    }

    //lista clientes
    public List<ClienteDTO> getAllClientes(){
        List<ClienteModel> clientes = repository.findAll(); //chama dados dos clientes
        return clientes.stream()//usa stream para converter a lista de model para dto
                .map(mapper::toDTO) //converte cada objeto da lista separadamente
                .collect(Collectors.toList());//usa os resultados da conversão para criar uma nova lista.
    }

    //lista por id
    public ClienteDTO getClienteById(Integer id){
        ClienteModel cliente = repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
        return mapper.toDTO(cliente);
    }

    //atualiza id
    public ClienteDTO upadateCliente(Integer id, ClienteDTO dto){
        if(!repository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado!"); //essa função verifica se id existe no banco, se não aparece a mensagem de erro
        }
        ClienteModel model = mapper.toEntity(dto); //converte dto para model
        model.setId(id); //chama cliente referente ao id buscado
        model = repository.save(model); //salva no banco
        return mapper.toDTO(model); //converte de model para dto novamente.
    }

    //deleta cliente e contatos.
    public void deleteCliente(Integer id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado!"); //verifica se cliente existe, se o id não estiver no repositorio ele aparece a mensagem de erro.
        }
        repository.deleteById(id); //deleta cliente e contatos.
    }
}