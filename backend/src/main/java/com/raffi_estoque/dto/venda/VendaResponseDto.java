package com.raffi_estoque.dto.venda;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class VendaResponseDto {

    private int codVenda;
    private int codCliente;
    private Double valorTotal;
    @JsonFormat(pattern = "HH'h'mm dd/MM/yyyy")
    private LocalDateTime dataVenda;
    private List<ItemVendaResponseDto> itens;

    public VendaResponseDto(){}

    public VendaResponseDto(int codVenda, int codCliente, Double valorTotal, LocalDateTime dataVenda, List<ItemVendaResponseDto> itens) {
        this.codVenda = codVenda;
        this.codCliente = codCliente;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.itens = itens;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<ItemVendaResponseDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemVendaResponseDto> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "VendaResponseDto{" +
                "codVenda=" + codVenda +
                ", codCliente=" + codCliente +
                ", itens=" + itens +
                ", valorTotal=" + valorTotal +
                ", dataVenda=" + dataVenda +
                '}';
    }
}
