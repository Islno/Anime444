package br.com.islno.anime444.anime444.dto;

import lombok.Data;

@Data
public class AnimeDto {
    private String title;
    private String synopsis;
    private Double score;
    private int episodes;
    private ImagesDto images;
}
