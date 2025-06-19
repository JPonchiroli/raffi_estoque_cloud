package com.raffi_estoque.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codVenda;

    private int codCliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens = new ArrayList<>();

    private Double valorTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH'h'mm dd/MM/yyyy")
    private LocalDateTime dataVenda;

    public Venda(){}

    public Venda(int codVenda, int codCliente, List<ItemVenda> itens, Double valorTotal, LocalDateTime dataVenda) {
        this.codVenda = codVenda;
        this.codCliente = codCliente;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
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

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
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

    @Override
    public String toString() {
        return "Venda{" +
                "codVenda=" + codVenda +
                ", codCliente=" + codCliente +
                ", itens=" + itens +
                ", valorTotal=" + valorTotal +
                ", dataVenda=" + dataVenda +
                '}';
    }
}
