package com.amanda.desafio.repository;

import com.amanda.desafio.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List; //retorna lista.

@Repository //marcação da interface de repositorio.
public interface ContatoRepository extends JpaRepository<ContatoModel, Integer> {

    @Query("SELECT obj FROM Contato obj Where obj.cliente.id = :id_cli ORDER BY nome")//busca personalizada para encontrar contatos pelo id do cliente, ordenado pelo nome.
    List<ContatoModel> findAllByCLiente(@Param(value = "id_cli") Integer id_cli);//retorna lista de contatos associadas ao cliente.
}
