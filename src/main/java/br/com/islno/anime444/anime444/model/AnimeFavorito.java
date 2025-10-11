package br.com.islno.anime444.anime444.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favoritos") // Define o nome exato da tabela
public class AnimeFavorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Diz ao PostgreSQL para gerar o ID automaticamente (auto-incremento)
    private Long id;


    private String title;
    private String imageUrl;
    private Double score;


}