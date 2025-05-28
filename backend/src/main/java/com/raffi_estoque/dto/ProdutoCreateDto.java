package com.raffi_estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProdutoCreateDto {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String unidadeMedida;

    @NotBlank
    @Positive
    private Double valorCusto;

    @NotBlank
    @Positive
    private Double valorVenda;

    @NotBlank
    private Integer estoqueAtual;

    @NotBlank
    private Integer estoqueMinimo;

    @NotBlank
    private Boolean avisoRepor;

    @NotBlank
    private Integer codFornecedor;


    public ProdutoCreateDto() {
    }

    public ProdutoCreateDto(String nomeProduto, String unidadeMedida, Double valorCusto, Double valorVenda, Integer estoqueAtual, Integer estoqueMinimo, Boolean avisoRepor, Integer codFornecedor) {
        this.nomeProduto = nomeProduto;
        this.unidadeMedida = unidadeMedida;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.estoqueAtual = estoqueAtual;
        this.estoqueMinimo = estoqueMinimo;
        this.avisoRepor = avisoRepor;
        this.codFornecedor = codFornecedor;
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

    public Boolean getAvisoRepor() {
        return avisoRepor;
    }

    public void setAvisoRepor(Boolean avisoRepor) {
        this.avisoRepor = avisoRepor;
    }

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    @Override
    public String toString() {
        return "ProdutoCreateDto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", valorCusto=" + valorCusto +
                ", valorVenda=" + valorVenda +
                ", estoqueAtual=" + estoqueAtual +
                ", estoqueMinimo=" + estoqueMinimo +
                ", avisoRepor=" + avisoRepor +
                '}';
    }
}