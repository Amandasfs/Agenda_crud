package com.amanda.desafio.dto;
//classe para especificar mensagens para o tratamento de erros
public class ApiError {
    private String message;
    private String details;

    public ApiError(String message, String details) {
        this.message = message;
        this.details = details;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
