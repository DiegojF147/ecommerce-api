package com.techlab.ecommerce.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Pedido con ID " + id + " no encontrado.");
    }
}

