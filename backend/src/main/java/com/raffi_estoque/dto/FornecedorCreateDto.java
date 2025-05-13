package com.raffi_estoque.dto;

import jakarta.validation.constraints.NotBlank;

public class FornecedorCreateDto {

    @NotBlank
    private String nomeFornecedor;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;

    public FornecedorCreateDto(){}

    public FornecedorCreateDto(String nomeFornecedor, String cnpj, String email, String telefone) {
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(@NotBlank String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank String cnpj) {
        this.cnpj = cnpj;
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
        return "FornecedorCreateDto{" +
                "nomeFornecedor='" + nomeFornecedor + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
