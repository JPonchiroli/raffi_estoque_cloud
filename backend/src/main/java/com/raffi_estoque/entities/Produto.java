package com.raffi_estoque.entities;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codProduto;
    private String nomeProduto;
    private String unidadeMedida;
    private double valorCusto;
    private double valorVenda;
    private int estoqueAtual;
    private int estoqueMinimo;

    @ManyToOne
    @JoinColumn(name = "codFornecedor", nullable = false)
    private Fornecedor fornecedor;

    public Produto(){}

    public Produto(int codProduto, String nomeProduto, String unidadeMedida, double valorCusto, double valorVenda, int estoqueAtual, int estoqueMinimo, Fornecedor fornecedor) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.unidadeMedida = unidadeMedida;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.estoqueAtual = estoqueAtual;
        this.estoqueMinimo = estoqueMinimo;
        this.fornecedor = fornecedor;
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

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
