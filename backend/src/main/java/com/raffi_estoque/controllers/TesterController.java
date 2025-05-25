package com.raffi_estoque.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TesterController {

    @GetMapping
    public String testRequest() {
        return "Raffi Estoque";
    }
}
