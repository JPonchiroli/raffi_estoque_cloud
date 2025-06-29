package com.raffi_estoque.dto.venda;

public class ItemVendaResponseDto {

    private Integer codProduto;
    private String nomeProduto;
    private Double valorUnitario;
    private Integer quantidade;
    private Double subTotal;

    public ItemVendaResponseDto(){}

    public ItemVendaResponseDto(Integer codProduto, String nomeProduto, Double valorUnitario, Integer quantidade, Double subTotal) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "ItemVendaResponseDto{" +
                "codProduto=" + codProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                ", subTotal=" + subTotal +
                '}';
    }
}
