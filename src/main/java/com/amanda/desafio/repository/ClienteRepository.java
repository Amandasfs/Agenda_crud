package com.amanda.desafio.repository;

import com.amanda.desafio.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    // nesse repositorio todos os metodos do JpaRepository podem ser usados pela entidade cliente.
}
