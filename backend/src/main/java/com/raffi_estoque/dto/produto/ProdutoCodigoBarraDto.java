package com.raffi_estoque.dto.produto;

public class ProdutoCodigoBarraDto {

    private Integer codProduto;
    private String codigoBarras;
    private String nomeProduto;

    public ProdutoCodigoBarraDto(){}

    public ProdutoCodigoBarraDto(Integer codProduto, String codigoBarras, String nomeProduto) {
        this.codProduto = codProduto;
        this.codigoBarras = codigoBarras;
        this.nomeProduto = nomeProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    @Override
    public String toString() {
        return "ProdutoCodigoBarraDto{" +
                "codProduto=" + codProduto +
                ", codigoBarras=" + codigoBarras +
                ", nomeProduto='" + nomeProduto + '\'' +
                '}';
    }
}
