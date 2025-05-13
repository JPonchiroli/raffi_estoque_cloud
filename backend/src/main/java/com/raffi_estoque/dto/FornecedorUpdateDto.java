package com.raffi_estoque.dto;

import jakarta.validation.constraints.NotBlank;

public class FornecedorUpdateDto {

    @NotBlank
    private String nomeFornecedor;

    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    public FornecedorUpdateDto() {}

    public FornecedorUpdateDto(String nomeFornecedor, String email, String telefone) {
        this.nomeFornecedor = nomeFornecedor;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(@NotBlank String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "FornecedorUpdateDto{" +
                "nomeFornecedor='" + nomeFornecedor + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
