package com.latita.products.service;

import com.latita.products.model.Product;
import com.latita.products.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository produtoRepository;

    public ProductService(ProductRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Product> listarTodos() {
        return produtoRepository.findAll();
    }

    public Product buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Product salvar(Product produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Product> buscarPorCategoria(String categoria) {
        return produtoRepository.findByCategoria(categoria);
    }

    public List<Product> buscarPersonalizaveis() {
        return produtoRepository.findByPersonalizavel(true);
    }
}