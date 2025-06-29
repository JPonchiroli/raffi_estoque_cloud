package com.raffi_estoque.feign;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;

import com.raffi_estoque.dto.viacep.ViaCepResponse;

@FeignClient(value = "ViaCepClient", url = "viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    ViaCepResponse getAddress(@PathVariable("cep") String cep);
}
