package com.raffi_estoque.dto.produto;

public class ProdutoResponseDto {

    private Integer codProduto;
    private String codigoBarras;
    private String nomeProduto;
    private String unidadeMedida;
    private Double valorCusto;
    private Integer porcentagemLucro;
    private Double valorVenda;
    private Integer estoqueAtual;
    private Integer estoqueMinimo;
    private Integer codFornecedor;

    public ProdutoResponseDto() {
    }

    public ProdutoResponseDto(Integer codProduto, String codigoBarras, String nomeProduto, String unidadeMedida, Double valorCusto, Integer porcentagemLucro, Double valorVenda, Integer estoqueAtual, Integer estoqueMinimo, Integer codFornecedor) {
        this.codProduto = codProduto;
        this.codigoBarras = codigoBarras;
        this.nomeProduto = nomeProduto;
        this.unidadeMedida = unidadeMedida;
        this.valorCusto = valorCusto;
        this.porcentagemLucro = porcentagemLucro;
        this.valorVenda = valorVenda;
        this.estoqueAtual = estoqueAtual;
        this.estoqueMinimo = estoqueMinimo;
        this.codFornecedor = codFornecedor;
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

    public Integer getPorcentagemLucro() {
        return porcentagemLucro;
    }

    public void setPorcentagemLucro(Integer porcentagemLucro) {
        this.porcentagemLucro = porcentagemLucro;
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

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    @Override
    public String toString() {
        return "ProdutoResponseDto{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", valorCusto=" + valorCusto +
                ", valorVenda=" + valorVenda +
                ", estoqueAtual=" + estoqueAtual +
                ", estoqueMinimo=" + estoqueMinimo +
                ", codFornecedor=" + codFornecedor +
                '}';
    }
}