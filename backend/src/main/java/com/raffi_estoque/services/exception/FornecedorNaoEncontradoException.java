package com.raffi_estoque.services.exception;

public class FornecedorNaoEncontradoException extends RuntimeException {
    public FornecedorNaoEncontradoException(String message) {
        super(message);
    }
}
