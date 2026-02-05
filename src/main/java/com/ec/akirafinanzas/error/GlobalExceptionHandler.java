package com.ec.akirafinanzas.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import io.jsonwebtoken.security.WeakKeyException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
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

        @ExceptionHandler(NoHandlerFoundException.class)
        private ResponseEntity<ApiErrorResponse> notFoundException(NoHandlerFoundException ex, WebRequest request) {
                String endpoint = request.getDescription(false).replace("uri=", "");
                ApiErrorResponse errorResponse = new ApiErrorResponse(
                                endpoint, ex.getMessage(), HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
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

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
                Map<String, String> errors = new HashMap<>();
                ex.getBindingResult().getFieldErrors()
                                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(errors);
        }

        @ExceptionHandler(WeakKeyException.class)
        public ResponseEntity<ApiErrorResponse> handleWeakKey(
                        WeakKeyException ex,
                        HttpServletRequest request) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(new ApiErrorResponse(
                                                request.getRequestURI(),
                                                "JWT secret key is too weak. Contact system administrator.",
                                                HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }

        @ExceptionHandler(InvalidCredentialsException.class)
        public ResponseEntity<ApiErrorResponse> handleInvalidCredentials(
                        InvalidCredentialsException ex,
                        HttpServletRequest request) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                .body(new ApiErrorResponse(
                                                request.getRequestURI(),
                                                ex.getMessage(),
                                                HttpStatus.UNAUTHORIZED.value()));
        }

        @ExceptionHandler(UserAlreadyExistsException.class)
        public ResponseEntity<ApiErrorResponse> handleUserAlreadyExists(
                        UserAlreadyExistsException ex,
                        HttpServletRequest request) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body(new ApiErrorResponse(
                                                request.getRequestURI(),
                                                ex.getMessage(),
                                                HttpStatus.CONFLICT.value()));
        }

        @ExceptionHandler(InvalidAuthDataException.class)
        public ResponseEntity<ApiErrorResponse> handleInvalidAuthData(
                        InvalidAuthDataException ex,
                        HttpServletRequest request) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(new ApiErrorResponse(
                                                request.getRequestURI(),
                                                ex.getMessage(),
                                                HttpStatus.BAD_REQUEST.value()));
        }

        @ExceptionHandler(UnauthorizedException.class)
        public ResponseEntity<ApiErrorResponse> handleUnauthorized(
                        UnauthorizedException ex,
                        HttpServletRequest request) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                .body(new ApiErrorResponse(
                                                request.getRequestURI(),
                                                ex.getMessage(),
                                                HttpStatus.UNAUTHORIZED.value()));
        }

}