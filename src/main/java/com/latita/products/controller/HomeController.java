package com.latita.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "API de Produtos LATITA está rodando! Acesse /api/produtos para ver os produtos";
    }
}