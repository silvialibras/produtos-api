package me.dio.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<me.dio.model.Produto> produtos;
}