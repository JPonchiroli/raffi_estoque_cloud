package com.raffi_estoque.dto;

import com.raffi_estoque.entities.Cliente;
import com.raffi_estoque.entities.Produto;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class VendaCreateDto {

    @NotBlank
    private Cliente cliente;
    @NotBlank
    private List<Produto> produtos;

    public VendaCreateDto() {}

    public VendaCreateDto(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public @NotBlank Cliente getCliente() {
        return cliente;
    }

    public void setCliente(@NotBlank Cliente cliente) {
        this.cliente = cliente;
    }

    public @NotBlank List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(@NotBlank List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "VendaCreateDto{" +
                "cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
