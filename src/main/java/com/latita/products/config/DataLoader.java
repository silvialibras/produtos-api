package com.latita.products.config;

import com.latita.products.model.*;
import com.latita.products.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner carregarDadosIniciais(ProductRepository repository) {
        return args -> {
            // Produto 1 - Camiseta
            Product camiseta = new Product();
            camiseta.setNome("Camiseta Básica");
            camiseta.setDescricao("100% algodão, estampa personalizável");
            camiseta.setPreco(49.90);
            camiseta.setCategoria(Categoria.CAMISETA);
            camiseta.setQuantidadeEstoque(100);
            camiseta.setQuantidadeMinima(10);
            camiseta.setPersonalizavel(true);
            camiseta.setMateriais(Arrays.asList(Material.ALGODAO));
            camiseta.setTamanhosDisponiveis(Arrays.asList(Size.P, Size.M, Size.G));

            // Produto 2 - Caneca
            Product caneca = new Product();
            caneca.setNome("Caneca Personalizada");
            caneca.setDescricao("Caneca de cerâmica 300ml");
            caneca.setPreco(29.90);
            caneca.setCategoria(Categoria.CANECA);
            caneca.setQuantidadeEstoque(50);
            caneca.setQuantidadeMinima(5);
            caneca.setPersonalizavel(true);
            caneca.setMateriais(Arrays.asList(Material.CERAMICA));
            caneca.setTamanhosDisponiveis(Arrays.asList(Size.UNICO));

            repository.saveAll(Arrays.asList(camiseta, caneca));
        };
    }
}