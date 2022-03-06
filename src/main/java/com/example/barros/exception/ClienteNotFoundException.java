package com.example.barros.exception;

public class ClienteNotFoundException extends RuntimeException {

        public ClienteNotFoundException(Long id) {
            super("City not found:"+ id);
        }
        public ClienteNotFoundException(String message) {
            super(message);
        }
        public ClienteNotFoundException() {
            super();
        }
}
