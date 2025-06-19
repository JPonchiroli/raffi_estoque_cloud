package com.raffi_estoque.dto;

public class ItemVendaResponseDto {

    private int codProduto;
    private String nomeProduto;
    private double valorUnitario;
    private int quantidade;
    private double subTotal;

    public ItemVendaResponseDto(){}

    public ItemVendaResponseDto(int codProduto, String nomeProduto, double valorUnitario, int quantidade, double subTotal) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
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
