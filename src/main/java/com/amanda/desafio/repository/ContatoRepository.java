package com.amanda.desafio.repository;

import com.amanda.desafio.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List; //retorna lista.

@Repository //marcação da ‘interface’ de repositorio.
public interface ContatoRepository extends JpaRepository<ContatoModel, Integer> {

    List<ContatoModel> findAllByClienteId(Integer clienteId);//busca personalizada para encontrar contatos pelo id do cliente, ordenado pelo nome.
}
