package com.freelancertracker.exception;

import com.freelancertracker.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Resource Not found exception
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTO> handleResourceNotFound(ResourceNotFoundException ex){

        ResponseDTO response = new ResponseDTO(
                ex.getMessage(), null
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Handle Duplicate resource found exception
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ResponseDTO> handleDuplicateResource(DuplicateResourceException ex){

        ResponseDTO response = new ResponseDTO(
                ex.getMessage(), null
        );

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    // Handle generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGenericExceptions(Exception ex){

        ResponseDTO response = new ResponseDTO(
                ex.getMessage(), null
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
