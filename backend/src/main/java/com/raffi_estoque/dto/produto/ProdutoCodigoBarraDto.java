package com.raffi_estoque.dto.produto;

public class ProdutoCodigoBarraDto {

    private Integer codProduto;
    private Long codigoBarras;

    public ProdutoCodigoBarraDto(){}

    public ProdutoCodigoBarraDto(Integer codProduto, Long codigoBarras) {
        this.codProduto = codProduto;
        this.codigoBarras = codigoBarras;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public String toString() {
        return "ProdutoCodigoBarraDto{" +
                "codProduto=" + codProduto +
                ", codigoBarras=" + codigoBarras +
                '}';
    }
}
