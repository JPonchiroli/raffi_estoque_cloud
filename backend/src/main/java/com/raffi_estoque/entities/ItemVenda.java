package com.raffi_estoque.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_itemVenda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codItemVenda;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;

    public ItemVenda(){}

    public ItemVenda(Integer codItemVenda, Venda venda, Produto produto, Integer quantidade) {
        this.codItemVenda = codItemVenda;
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Integer getCodItemVenda() {
        return codItemVenda;
    }

    public void setCodItemVenda(Integer codItemVenda) {
        this.codItemVenda = codItemVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "codItemVenda=" + codItemVenda +
                ", venda=" + venda +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
