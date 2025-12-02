package com.ec.akirafinanzas.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        String endpoint = request.getDescription(false).replace("uri=", "");
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                endpoint,
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex,
            WebRequest request) {
        String endpoint = request.getDescription(false).replace("uri=", "");
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                endpoint,
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}