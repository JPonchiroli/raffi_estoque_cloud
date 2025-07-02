package com.raffi_estoque.dto.fornecedor;

import jakarta.validation.constraints.NotBlank;

public class FornecedorUpdateDto {

    private String nomeFornecedor;
    private String cnpj;
    private String email;
    private String telefone;
    private String cep;
    private Integer numeroRua;
    private String complemento;

    public FornecedorUpdateDto() {}

    public FornecedorUpdateDto(String nomeFornecedor, String cnpj, String email, String telefone, String cep, Integer numeroRua, String complemento) {
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.numeroRua = numeroRua;
        this.complemento = complemento;
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

    public Integer getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(Integer numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
