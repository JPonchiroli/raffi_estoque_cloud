package com.raffi_estoque.controllers;

import com.raffi_estoque.dto.viacep.ViaCepResponse;
import com.raffi_estoque.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "http://localhost:3000")
public class Address {

    @Autowired
    private AddressService addressService;

    @GetMapping("/get-address/{cep}")
    public ViaCepResponse getAddress(@PathVariable String cep) {
        return addressService.getAddress(cep);
    }
}
