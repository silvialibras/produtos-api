package com.latita.products.controller;

import com.latita.products.model.Product;
import com.latita.products.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listarTodos() {
        return productService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> buscarPorId(@PathVariable Long id) {
        Product produto = productService.buscarPorId(id);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Product criar(@RequestBody Product produto) {
        return productService.salvar(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> atualizar(@PathVariable Long id, @RequestBody Product produto) {
        if (productService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        produto.setId(id);
        return ResponseEntity.ok(productService.salvar(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (productService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        productService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Product> buscarPorCategoria(@PathVariable String categoria) {
        return productService.buscarPorCategoria(categoria);
    }

    @GetMapping("/personalizaveis")
    public List<Product> buscarPersonalizaveis() {
        return productService.buscarPersonalizaveis();
    }

    @GetMapping("/estoque-baixo")
    public List<Product> buscarProdutosComEstoqueBaixo() {
        return productService.buscarProdutosComEstoqueBaixo();
    }

    @PostMapping("/{id}/adicionar-estoque")
    public ResponseEntity<Product> adicionarEstoque(
            @PathVariable Long id,
            @RequestParam Integer quantidade) {
        Product produto = productService.adicionarEstoque(id, quantidade);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/remover-estoque")
    public ResponseEntity<Product> removerEstoque(
            @PathVariable Long id,
            @RequestParam Integer quantidade) {
        Product produto = productService.removerEstoque(id, quantidade);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }
}