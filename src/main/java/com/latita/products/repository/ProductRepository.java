package com.latita.products.repository;

import com.latita.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoria(String categoria);
    List<Product> findByPersonalizavel(Boolean personalizavel);
    List<Product> findByPrecoBetween(Double precoMin, Double precoMax);
    List<Product> findByQuantidadeEstoqueLessThan(Integer quantidade);
    List<Product> findByQuantidadeEstoqueGreaterThan(Integer quantidade);
}