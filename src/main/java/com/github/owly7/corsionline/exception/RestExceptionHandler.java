package com.github.owly7.corsionline.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.owly7.corsionline.web.dto.ErroreDTO;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroreDTO> handleResourceNotFound(ResourceNotFoundException exception) {
        ErroreDTO errore = new ErroreDTO(
            HttpStatus.NOT_FOUND.value(),
            exception.getMessage(),
            System.currentTimeMillis()
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errore);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroreDTO> handleException(Exception exception) {
        ErroreDTO errore = new ErroreDTO(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Errore interno del server",
            System.currentTimeMillis()
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errore);
    }

}
