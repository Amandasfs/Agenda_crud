package com.amanda.desafio.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

  private static final long serialVersionUIDLONG = 1L;

  public DataIntegrityViolationException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataIntegrityViolationException(String message) {
    super(message);
  }
}