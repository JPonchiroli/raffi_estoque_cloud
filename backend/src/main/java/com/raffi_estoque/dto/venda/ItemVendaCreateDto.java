package com.raffi_estoque.dto.venda;

public class ItemVendaCreateDto {
    private Integer codProduto;
    private Integer quantidade;

    public ItemVendaCreateDto(){}

    public ItemVendaCreateDto(Integer codProduto, Integer quantidade) {
        this.codProduto = codProduto;
        this.quantidade = quantidade;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
