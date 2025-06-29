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

    public boolean isCepZerado(String cep) {
        return cep.replaceAll("[^0-9]", "").equals("00000000");
    }

    public String zerarCep(String cep) {
        if (cep == null || cep.isBlank()) {
            return "00000000";
        }

        String somenteNumeros = cep.replaceAll("\\D", "");

        if (somenteNumeros.isBlank() || somenteNumeros.equals("0") || somenteNumeros.matches("^0+$")) {
            return "00000000";
        }

        return somenteNumeros;
    }
}
