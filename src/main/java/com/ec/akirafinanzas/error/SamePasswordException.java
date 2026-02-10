package com.ec.akirafinanzas.error;

public class SamePasswordException extends RuntimeException {
    public SamePasswordException(String message) {
        super(message);
    }

}
