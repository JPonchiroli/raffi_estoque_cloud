package com.raffi_estoque.controllers;

import com.raffi_estoque.dto.ClienteCreateDto;
import com.raffi_estoque.dto.ClienteResponseDto;
import com.raffi_estoque.dto.ClienteUpdateDto;
import com.raffi_estoque.entities.Cliente;
import com.raffi_estoque.services.ClienteService;
import com.raffi_estoque.mapper.ClienteMapper;
import com.raffi_estoque.dto.ViaCepResponse;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping("/create-cliente")
    public ResponseEntity<ClienteResponseDto> createCliente(@RequestBody ClienteCreateDto cliente) {
        Cliente clienteCreated = mapper.toCliente(cliente);
        String cep = cliente.getCep();
        ViaCepResponse address = getAddress(cep);

        clienteCreated.setRua(address.getLogradouro());
        clienteCreated.setBairro(address.getBairro());
        clienteCreated.setCidade(address.getLocalidade());
        clienteCreated.setUf(address.getUf());

        clienteService.save(clienteCreated);
        return ResponseEntity.status(201).body(mapper.toClienteResponseDto(clienteCreated));
    }

    @GetMapping("/get-cliente/{id}")
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable("id") Integer id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(mapper.toClienteResponseDto(cliente));
    }

    @GetMapping("/get-all-clientes")
    public ResponseEntity<List<ClienteResponseDto>> findAll(){
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok().body(mapper.toListResponseDto(clientes));
    }

    @PutMapping("/update-cliente/{id}")
    public ResponseEntity<ClienteUpdateDto> updateCliente(@PathVariable Integer id, @RequestBody @Valid ClienteUpdateDto updateDto){
        Cliente cliente = clienteService.update(id, mapper.toCliente(updateDto));
        return ResponseEntity.ok(mapper.toUpdate(cliente));
    }

    @DeleteMapping("/deletar-cliente/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Integer id){
        clienteService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-address/{cep}")
    public ViaCepResponse getAddress(@PathVariable String cep) {
        return clienteService.getAddress(cep);
    }

}