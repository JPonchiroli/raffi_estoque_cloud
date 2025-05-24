package com.raffi_estoque.controllers;

import com.raffi_estoque.dto.*;
import com.raffi_estoque.entities.Cliente;
import com.raffi_estoque.entities.Fornecedor;
import com.raffi_estoque.mapper.FornecedorMapper;
import com.raffi_estoque.services.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private FornecedorMapper mapper;

    @PostMapping("/create-fornecedor")
    public ResponseEntity<FornecedorResponseDto> createEvent(@RequestBody FornecedorCreateDto fornecedor) {
        Fornecedor fornecedorCreated = mapper.toFornecedor(fornecedor);
        String cep = fornecedor.getCep();
        ViaCepResponse address = getAddress(cep);

        fornecedorCreated.setRua(address.getLogradouro());
        fornecedorCreated.setBairro(address.getBairro());
        fornecedorCreated.setCidade(address.getLocalidade());
        fornecedorCreated.setUf(address.getUf());

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
    public ResponseEntity<FornecedorUpdateDto> updateEvent(@PathVariable Integer id, @RequestBody @Valid FornecedorUpdateDto updateDto){
        Fornecedor fornecedor = fornecedorService.update(id, mapper.toFornecedor(updateDto));
        return ResponseEntity.ok(mapper.toUpdate(fornecedor));
    }

    @GetMapping("/get-address/{cep}")
    public ViaCepResponse getAddress(@PathVariable String cep) {
        return fornecedorService.getAddress(cep);
    }
}
