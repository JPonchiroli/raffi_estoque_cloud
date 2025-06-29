package com.raffi_estoque.services.exception;

public class VendaNaoEncontradaException extends RuntimeException {
    public VendaNaoEncontradaException(String message) {
        super(message);
    }
}
