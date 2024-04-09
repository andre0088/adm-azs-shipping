package com.adm.azs.shipping.application.exception;

public class BadRequestException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BadRequestException() {
        super("A requisição é inválida.");
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
