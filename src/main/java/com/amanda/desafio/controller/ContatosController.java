package com.amanda.desafio.controller;

import com.amanda.desafio.dto.ContatoDTO;
import com.amanda.desafio.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatosController {

    @Autowired
    private ContatoService service;

    // Endpoint para criar um contato
    @PostMapping
    public ResponseEntity<ContatoDTO> createContato(@RequestBody ContatoDTO dto) {
        ContatoDTO create = service.createContato(dto);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    // Endpoint para buscar todos os contatos de um cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<ContatoDTO>> getContatosByClienteId(@PathVariable Integer clienteId) {
        List<ContatoDTO> contatos = service.getContatosByClienteId(clienteId);
        return new ResponseEntity<>(contatos, HttpStatus.OK);
    }

    // Endpoint para buscar um contato específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<ContatoDTO> getContatoById(@PathVariable Integer id) {
        ContatoDTO dto = (ContatoDTO) service.getContatosByClienteId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // Endpoint para atualizar um contato
    @PutMapping("/{id}")
    public ResponseEntity<ContatoDTO> updateContato(@PathVariable Integer id, @RequestBody ContatoDTO dto) {
        ContatoDTO updated = service.updateContato(id, dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Endpoint para deletar um contato
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContato(@PathVariable Integer id) {
        service.deleteContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
