package com.raffi_estoque.dto.cliente;

public class ClienteNomeDto {
    private Integer codCliente;
    private String nomeCliente;

    public ClienteNomeDto(){}

    public ClienteNomeDto(String nomeCliente, Integer codCliente) {
        this.nomeCliente = nomeCliente;
        this.codCliente = codCliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
