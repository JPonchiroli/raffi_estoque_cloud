package com.raffi_estoque.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codVenda;

    @ManyToOne
    @JoinColumn(name = "codCliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "vendaProduto",
            joinColumns = @JoinColumn(name = "codVenda"),
            inverseJoinColumns = @JoinColumn(name = "codProduto")
    )
    private List<Produto> produtos;

    public Venda(){}

    public Venda(int codVenda, Cliente cliente, List<Produto> produtos) {
        this.codVenda = codVenda;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "codVenda=" + codVenda +
                ", cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
