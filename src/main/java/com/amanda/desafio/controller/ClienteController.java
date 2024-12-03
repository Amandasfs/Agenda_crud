package com.amanda.desafio.controller;

import com.amanda.desafio.dto.ClienteDTO;
import com.amanda.desafio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController { // Corrigido o nome da classe

    @Autowired
    private ClienteService service;

    // Endpoint para criar um cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO dto) {
        ClienteDTO create = service.createCliente(dto);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientes = service.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para buscar um cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Integer id) {
        ClienteDTO dto = service.getClienteById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // Endpoint para atualizar um cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Integer id, @RequestBody ClienteDTO dto) { // Corrigido o nome do método
        ClienteDTO updated = service.upadateCliente(id, dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Endpoint para deletar um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) { // Corrigido o nome do método
        service.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}