package com.techlab.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TechlabEcommerceException extends RuntimeException {
    protected final String title;
    protected final HttpStatus status;

    public TechlabEcommerceException(String title, String message, HttpStatus status) {
        super(message);
        this.title = title;
        this.status = status;
    }
}

