package com.raffi_estoque.controllers;

import com.raffi_estoque.dto.fornecedor.FornecedorCreateDto;
import com.raffi_estoque.dto.fornecedor.FornecedorNomeDto;
import com.raffi_estoque.dto.fornecedor.FornecedorResponseDto;
import com.raffi_estoque.dto.fornecedor.FornecedorUpdateDto;
import com.raffi_estoque.dto.viacep.ViaCepResponse;
import com.raffi_estoque.entities.Fornecedor;
import com.raffi_estoque.mapper.FornecedorMapper;
import com.raffi_estoque.services.FornecedorService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fornecedores")
@CrossOrigin(origins = "http://localhost:3000")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private FornecedorMapper mapper;

    @PostMapping("/create-fornecedor")
    public ResponseEntity<FornecedorResponseDto> createFornecedor(@RequestBody FornecedorCreateDto fornecedor) {
        Fornecedor fornecedorCreated = mapper.toFornecedor(fornecedor);
        fornecedorService.save(fornecedorCreated);
        return ResponseEntity.status(201).body(mapper.toFornecedorResponseDto(fornecedorCreated));
    }

    @GetMapping("/get-fornecedor/{id}")
    public ResponseEntity<FornecedorResponseDto> findById(@PathVariable("id") Integer id){
        Fornecedor fornecedor = fornecedorService.findById(id);
        return ResponseEntity.ok().body(mapper.toFornecedorResponseDto(fornecedor));
    }

    @GetMapping("/get-all-fornecedores")
    public ResponseEntity<List<FornecedorResponseDto>> findAll(){
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        return ResponseEntity.ok().body(mapper.toListResponseDto(fornecedores));
    }

    @PutMapping("/update-fornecedor/{id}")
    public ResponseEntity<FornecedorUpdateDto> updateFornecedor(@PathVariable Integer id, @RequestBody @Valid FornecedorUpdateDto updateDto){
        Fornecedor fornecedor = fornecedorService.update(id, mapper.toFornecedor(updateDto));
        return ResponseEntity.ok(mapper.toUpdate(fornecedor));
    }

    @DeleteMapping("/deletar-fornecedor/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable("id") Integer id){
        fornecedorService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-address/{cep}")
    public ViaCepResponse getAddress(@PathVariable String cep) {
        return fornecedorService.getAddress(cep);
    }

    @GetMapping("/get-fornecedor-nome/{nomeFornecedor}")
    public List<FornecedorNomeDto> getFornecedorPorNome(@PathVariable String nomeFornecedor) {
        List<Fornecedor> fornecedores = fornecedorService.findFornecedorPorNome(nomeFornecedor);
        return fornecedores.stream()
                .map(f -> new FornecedorNomeDto(f.getNomeFornecedor(), f.getCodFornecedor()))
                .collect(Collectors.toList());
    }

}
