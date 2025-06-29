package com.raffi_estoque.controllers;

import com.raffi_estoque.dto.venda.ItemVendaResponseDto;
import com.raffi_estoque.dto.venda.VendaCreateDto;
import com.raffi_estoque.dto.venda.VendaResponseDto;
import com.raffi_estoque.entities.*;
import com.raffi_estoque.mapper.VendaMapper;
import com.raffi_estoque.services.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "http://localhost:3000")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private VendaMapper mapper;

    @PostMapping("/create-venda")
    public ResponseEntity<VendaResponseDto> createVenda(@RequestBody VendaCreateDto dto) {
        Venda venda = vendaService.salvarVenda(dto);
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
        vendaService.deleteById(codVenda);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-itens-venda/{codVenda}")
    public ResponseEntity<List<ItemVendaResponseDto>> getItensVenda(@PathVariable("codVenda") int codVenda) {
        List<ItemVenda> itensVenda = vendaService.findItensVendaByVendaId(codVenda);
        List<ItemVendaResponseDto> response = itensVenda.stream()
                .map(mapper::toItemVendaResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}
