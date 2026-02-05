package com.ec.akirafinanzas.error;

public class InvalidAuthDataException extends RuntimeException {
    public InvalidAuthDataException(String message) {
        super(message);
    }
}
