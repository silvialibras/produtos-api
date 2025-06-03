package com.latita.products.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    private String imagemUrl;

    @Column(nullable = false)
    private Boolean personalizavel;

    @ElementCollection
    @CollectionTable(name = "produto_materiais", joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "material")
    @Enumerated(EnumType.STRING)
    private List<Material> materiais;

    @ElementCollection
    @CollectionTable(name = "produto_tamanhos", joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "tamanho")
    @Enumerated(EnumType.STRING)
    private List<Size> tamanhosDisponiveis;

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    public void setId(Long id) {

    }

    // Getters e Setters (gerados pelo IDE ou Lombok)
    // Construtores
}