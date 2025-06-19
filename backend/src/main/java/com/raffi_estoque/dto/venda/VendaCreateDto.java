package com.raffi_estoque.dto.venda;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class VendaCreateDto {

    @NotBlank
    private int codCliente;

    @NotBlank
    private List<ItemVendaCreateDto> itens;

    public VendaCreateDto(){}

    public VendaCreateDto(int codCliente, List<ItemVendaCreateDto> itens) {
        this.codCliente = codCliente;
        this.itens = itens;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public List<ItemVendaCreateDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaCreateDto> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "VendaCreateDto{" +
                "codCliente=" + codCliente +
                ", itens=" + itens +
                '}';
    }
}
