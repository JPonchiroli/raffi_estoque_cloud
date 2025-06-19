package com.raffi_estoque.services;

import com.raffi_estoque.dto.viacep.ViaCepResponse;
import com.raffi_estoque.feign.ViaCepClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private ViaCepClient viaCepclient;

    public ViaCepResponse getAddress(String cep) {
        return viaCepclient.getAddress(cep);
    }
}
