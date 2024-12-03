package com.amanda.desafio.controller;

import com.amanda.desafio.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBController {

    @Autowired
    private DBService service;

    @Bean
    public CommandLineRunner initializeDatabase() {//metodo que permite a incersão de dados
        return args -> {
            this.service.instantiateDatabase();
            System.out.println("Banco de dados inicializado!");
        };
    }
}
