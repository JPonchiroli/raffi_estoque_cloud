package com.raffi_estoque.controllers;

import com.raffi_estoque.dto.ViaCepResponse;
import com.raffi_estoque.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class Address {

    @Autowired
    private AddressService addressService;

    @GetMapping("/get-address/{cep}")
    public ViaCepResponse getAddress(@PathVariable String cep) {
        return addressService.getAddress(cep);
    }
}
