package com.latita.products.service;

import com.latita.products.model.Product;
import com.latita.products.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listarTodos() {
        return productRepository.findAll();
    }

    public Product buscarPorId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product salvar(Product produto) {
        return productRepository.save(produto);
    }

    public void deletar(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> buscarPorCategoria(String categoria) {
        return productRepository.findByCategoria(categoria);
    }

    public List<Product> buscarPersonalizaveis() {
        return productRepository.findByPersonalizavel(true);
    }

    public List<Product> buscarProdutosComEstoqueBaixo() {
        return productRepository.findByQuantidadeEstoqueLessThan(10);
    }

    public Product adicionarEstoque(Long id, Integer quantidade) {
        Product produto = productRepository.findById(id).orElse(null);
        if (produto != null) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
            return productRepository.save(produto);
        }
        return null;
    }

    public Product removerEstoque(Long id, Integer quantidade) {
        Product produto = productRepository.findById(id).orElse(null);
        if (produto != null && produto.getQuantidadeEstoque() >= quantidade) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
            return productRepository.save(produto);
        }
        return null;
    }
}