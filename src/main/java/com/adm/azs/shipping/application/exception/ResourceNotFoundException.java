package com.adm.azs.shipping.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Long id) {
        super("O recurso com o ID " + id + " não foi encontrado.");
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
