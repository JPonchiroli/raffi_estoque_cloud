package com.raffi_estoque.dto;

public class ItemVendaCreateDto {
    private int codProduto;
    private int quantidade;

    public ItemVendaCreateDto(){}

    public ItemVendaCreateDto(int codProduto, int quantidade) {
        this.codProduto = codProduto;
        this.quantidade = quantidade;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
