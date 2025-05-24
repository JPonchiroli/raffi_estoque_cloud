package com.raffi_estoque.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FornecedorCreateDto {

    @NotBlank
    private String nomeFornecedor;
    @NotBlank
    private String cnpj;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;
    @NotBlank
    private String complemento;
    @NotBlank
    private Integer numeroRua;

    public FornecedorCreateDto(){}

    public FornecedorCreateDto(String nomeFornecedor, String cnpj, String email, String telefone, String cep, String complemento, Integer numeroRua) {
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.complemento = complemento;
        this.numeroRua = numeroRua;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(Integer numeroRua) {
        this.numeroRua = numeroRua;
    }

    @Override
    public String toString() {
        return "FornecedorCreateDto{" +
                "nomeFornecedor='" + nomeFornecedor + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", complemento='" + complemento + '\'' +
                ", numeroRua=" + numeroRua +
                '}';
    }
}
