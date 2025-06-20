package com.raffi_estoque.dto.cliente;

public class ClienteNomeDto {
    private int codCliente;
    private String nomeCliente;

    public ClienteNomeDto(){}

    public ClienteNomeDto(int codCliente, String nomeCliente) {
        this.codCliente = codCliente;
        this.nomeCliente = nomeCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
