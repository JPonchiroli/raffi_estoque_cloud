package com.raffi_estoque.controllers;

import com.raffi_estoque.dto.venda.ItemVendaCreateDto;
import com.raffi_estoque.dto.venda.VendaCreateDto;
import com.raffi_estoque.dto.venda.VendaResponseDto;
import com.raffi_estoque.entities.*;
import com.raffi_estoque.mapper.VendaMapper;
import com.raffi_estoque.repositories.ClienteRepository;
import com.raffi_estoque.repositories.ProdutoRepository;
import com.raffi_estoque.services.ProdutoService;
import com.raffi_estoque.services.VendaService;
import com.raffi_estoque.services.exception.EstoqueInsuficienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VendaMapper mapper;

    @CrossOrigin(origins = "*")
    @PostMapping("/create-venda")
    public ResponseEntity<VendaResponseDto> createVenda(@RequestBody VendaCreateDto dto) {
        Venda venda = new Venda();
        venda.setCodCliente(dto.getCodCliente());
        venda.setDataVenda(LocalDateTime.now());

        double totalVenda = 0.0;
        List<ItemVenda> itens = new ArrayList<>();

        for (ItemVendaCreateDto itemDto : dto.getItens()) {
            Produto produto = produtoRepository.findById(itemDto.getCodProduto())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

            ItemVenda item = new ItemVenda();
            item.setProduto(produto);
            item.setQuantidade(itemDto.getQuantidade());
            item.setVenda(venda);

            double subTotal = produto.getValorVenda() * itemDto.getQuantidade();
            totalVenda += subTotal;

            itens.add(item);

            produto.setEstoqueAtual(produto.getEstoqueAtual() - itemDto.getQuantidade());

            if (produto.getEstoqueAtual() <= produto.getEstoqueMinimo()) {
                throw new EstoqueInsuficienteException("Estoque do produto " + produto.getNomeProduto() + " atingirá o mínimo permitido.");
            }

            produtoService.update(produto.getCodProduto(), produto);
        }

        venda.setItens(itens);
        venda.setValorTotal(totalVenda);

        vendaService.save(venda);

        return ResponseEntity.status(201).body(mapper.toVendaResponseDto(venda));
    }

    @GetMapping("/get-venda/{id}")
    public ResponseEntity<VendaResponseDto> getVenda(@PathVariable("id") int codVenda) {
        Venda venda = vendaService.findById(codVenda);
        return ResponseEntity.ok(mapper.toVendaResponseDto(venda));
    }

    @GetMapping("/get-all-vendas")
    public ResponseEntity<List<VendaResponseDto>> getAllVendas() {
        List<Venda> vendas = vendaService.findAll();
        return ResponseEntity.ok(mapper.toListResponseDto(vendas));
    }

    @DeleteMapping("/delete-venda/{id}")
    public ResponseEntity<Void> deleteVenda(@PathVariable("id") int codVenda) {
        Venda venda = vendaService.findById(codVenda);
        List<ItemVenda> itens = venda.getItens();

        for (ItemVenda item: itens) {
            int codProduto = item.getProduto().getCodProduto();

            Produto produto = produtoService.findById(codProduto);

            produto.setEstoqueAtual(produto.getEstoqueAtual() + item.getQuantidade());

            produtoService.update(codProduto, produto);
        }

        vendaService.deleteById(codVenda);
        return ResponseEntity.noContent().build();
    }


}
