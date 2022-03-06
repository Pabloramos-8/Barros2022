package com.example.barros.exception;

public class EventoNotFoundException extends RuntimeException {

    public EventoNotFoundException(Long id) {
        super("City not found:"+ id);
    }
    public EventoNotFoundException(String message) {
        super(message);
    }
    public EventoNotFoundException() {
        super();
    }
}