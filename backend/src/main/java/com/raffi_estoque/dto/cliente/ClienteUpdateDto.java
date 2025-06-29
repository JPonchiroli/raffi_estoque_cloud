package com.raffi_estoque.dto.cliente;

import jakarta.validation.constraints.NotBlank;

public class ClienteUpdateDto {

    private String nomeCliente;
    private String cep;
    private Integer numeroRua;;
    private String complemento;

    public ClienteUpdateDto() {}

    public ClienteUpdateDto(String nomeCliente, String cep, Integer numeroRua, String complemento) {
        this.nomeCliente = nomeCliente;
        this.cep = cep;
        this.numeroRua = numeroRua;
        this.complemento = complemento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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
