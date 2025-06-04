package com.raffi_estoque.dto;

import com.raffi_estoque.entities.Cliente;
import com.raffi_estoque.entities.Produto;

import java.util.List;

public class VendaResponseDto {
    private int codVenda;

    private Cliente cliente;

    private List<Produto> produtos;

    public VendaResponseDto(){}

    public VendaResponseDto(int codVenda, Cliente cliente, List<Produto> produtos) {
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
        return "VendaResponseDto{" +
                "codVenda=" + codVenda +
                ", cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
