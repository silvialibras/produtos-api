package com.latita.products.controller;

import com.latita.products.model.Product;
import com.latita.products.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")  // Define o prefixo da URL
public class ProductController {

    private final ProductService produtoService;

    // Injeção de dependência
    public ProductController(ProductService produtoService) {
        this.produtoService = produtoService;
    }

    // Endpoint para listar todos os produtos
    @GetMapping
    public List<Product> listarTodos() {
        return produtoService.listarTodos();
    }

    // Endpoint para buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> buscarPorId(@PathVariable Long id) {
        Product produto = produtoService.buscarPorId(id);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }
    // Adicionar produto (POST)
    @PostMapping
    public ResponseEntity<Product> criarProduto(@RequestBody Product produto) {
        Product produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.status(201).body(produtoSalvo); // HTTP 201 = Created
    }

    // Atualizar produto (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Product> atualizarProduto(
            @PathVariable Long id,
            @RequestBody Product produto
    ) {
        produto.setId(id); // Garante que o ID seja o mesmo da URL
        Product produtoAtualizado = produtoService.salvar(produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    // Deletar produto (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build(); // HTTP 204 = No Content
    }
}