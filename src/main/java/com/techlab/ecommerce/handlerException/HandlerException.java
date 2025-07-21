package com.techlab.ecommerce.handlerException;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.techlab.ecommerce.dto.response.ExceptionResponseDTO;
import com.techlab.ecommerce.exception.TechlabEcommerceException;

@Hidden
@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(TechlabEcommerceException.class)
    public ResponseEntity<ExceptionResponseDTO> techlabEcommerceException(TechlabEcommerceException e) {
        ExceptionResponseDTO dto = new ExceptionResponseDTO();
        dto.setTitle(e.getTitle());
        dto.setMessage(e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(dto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> defaultHandler(Exception e) {
        ExceptionResponseDTO dto = new ExceptionResponseDTO();
        dto.setTitle("Problema inesperado en el servidor");
        dto.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
    }
}

