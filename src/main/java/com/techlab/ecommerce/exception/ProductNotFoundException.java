package com.techlab.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends TechlabEcommerceException {
    public ProductNotFoundException(String queryTerm) {
        super("Product could not be found",
                String.format("No se encontró el producto con el término: <%s>", queryTerm),
                HttpStatus.NOT_FOUND);
    }
}

