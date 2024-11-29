package com.amanda.desafio.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // construtor com os parametros mensagem e causa.
    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // construtor com somente a mensagem.
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
