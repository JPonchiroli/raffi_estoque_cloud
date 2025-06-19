package com.raffi_estoque.controllers;

import com.raffi_estoque.dto.produto.ProdutoCreateDto;
import com.raffi_estoque.dto.produto.ProdutoResponseDto;
import com.raffi_estoque.dto.produto.ProdutoUpdateDto;
import com.raffi_estoque.entities.Fornecedor;
import com.raffi_estoque.entities.Produto;
import com.raffi_estoque.mapper.ProdutoMapper;
import com.raffi_estoque.repositories.FornecedorRepository;
import com.raffi_estoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ProdutoMapper mapper;

    @PostMapping("/create-produto")
    public ResponseEntity<ProdutoResponseDto> createEvent(@RequestBody ProdutoCreateDto produto) {
        Produto produtoCreated = mapper.toProduto(produto);

        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(produto.getCodFornecedor());

        fornecedor.ifPresent(produtoCreated::setFornecedor);

        produtoService.save(produtoCreated);
        return ResponseEntity.status(201).body(mapper.toProdutoResponseDto(produtoCreated));
    }

    @GetMapping("/get-produto/{id}")
    public ResponseEntity<ProdutoResponseDto> findById(@PathVariable("id") Integer id){
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(mapper.toProdutoResponseDto(produto));
    }

    @GetMapping("/get-all-produtos")
    public ResponseEntity<List<ProdutoResponseDto>> findAll(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok().body(mapper.toListResponseDto(produtos));
    }

    @PutMapping("/update-produto/{id}")
    public ResponseEntity<ProdutoUpdateDto> updateEvent(@PathVariable Integer id, @RequestBody ProdutoUpdateDto updateDto){
        Produto produtos = produtoService.update(id, mapper.toProduto(updateDto));
        return ResponseEntity.ok(mapper.toUpdate(produtos));
    }

    @DeleteMapping("/deletar-produto/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable("id") Integer id){
        produtoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}