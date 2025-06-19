package com.raffi_estoque.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoUpdateDto {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String unidadeMedida;

    @NotBlank
    @Positive(message = "O valor de custo deve ser maior que zero")
    private Double valorCusto;

    @NotBlank
    @Positive(message = "O valor de venda deve ser maior que zero")
    private Double valorVenda;

    @NotBlank
    private Integer estoqueAtual;

    @NotBlank
    private Integer estoqueMinimo;

    public ProdutoUpdateDto() {
    }

    public ProdutoUpdateDto(String nomeProduto, String unidadeMedida, Double valorCusto, Double valorVenda, Integer estoqueAtual, Integer estoqueMinimo) {
        this.nomeProduto = nomeProduto;
        this.unidadeMedida = unidadeMedida;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.estoqueAtual = estoqueAtual;
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(Integer estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public String toString() {
        return "ProdutoUpdateDto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", valorCusto=" + valorCusto +
                ", valorVenda=" + valorVenda +
                ", estoqueAtual=" + estoqueAtual +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}