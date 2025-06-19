package com.raffi_estoque.dto.fornecedor;

public class FornecedorNomeDto {

    private Integer codFornecedor;
    private String nomeFornecedor;

    public FornecedorNomeDto(){}

    public FornecedorNomeDto(String nomeFornecedor, Integer codFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
        this.codFornecedor = codFornecedor;
    }

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    @Override
    public String toString() {
        return "FornecedorNomeDto{" +
                "codFornecedor=" + codFornecedor +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                '}';
    }
}
