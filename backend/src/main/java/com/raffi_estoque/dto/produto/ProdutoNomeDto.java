package com.raffi_estoque.dto.produto;

import com.raffi_estoque.entities.Produto;

public class ProdutoNomeDto {
    private Integer codProduto;
    private String nomeProduto;

    public ProdutoNomeDto(){}

    public ProdutoNomeDto(Integer codProduto, String nomeProduto) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
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
}
