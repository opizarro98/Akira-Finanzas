package com.ec.akirafinanzas.error;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorResponse {

    private String endpoint;
    private String message;
    private LocalDateTime timestamp;
    private int statusCode;

    public ApiErrorResponse(String endpoint, String message, int statusCode) {
        this.endpoint = endpoint;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.statusCode = statusCode;
    }
}