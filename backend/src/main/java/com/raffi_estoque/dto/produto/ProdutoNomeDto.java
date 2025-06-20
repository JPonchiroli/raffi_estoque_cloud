package com.raffi_estoque.dto.produto;

import com.raffi_estoque.entities.Produto;

public class ProdutoNomeDto {
    private int codProduto;
    private String nomeProduto;

    public ProdutoNomeDto(){}

    public ProdutoNomeDto(int codProduto, String nomeProduto) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
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
}
