package com.raffi_estoque.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class ClienteUpdateDto {

    @NotBlank
    private String nomeCliente;

    @NotBlank
    private String complemento;

    public ClienteUpdateDto() {}

    public ClienteUpdateDto(String nomeCliente, String complemento) {
        this.nomeCliente = nomeCliente;
        this.complemento = complemento;
    }

    public @NotBlank String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(@NotBlank String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public @NotBlank String getComplemento() {
        return complemento;
    }

    public void setComplemento(@NotBlank String complemento) {
        this.complemento = complemento;
    }
}
