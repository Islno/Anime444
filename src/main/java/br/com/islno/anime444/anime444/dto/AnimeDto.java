package br.com.islno.anime444.anime444.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimeDto {
    @NotBlank(message = "O Titulo não pode estar em branco.")
    private String title;
    private String synopsis;
   @NotNull(message = "A nota não pode ser nula")
    private Double score;
    private int episodes;
    @NotNull(message = "Deve ter uma imagem")
    private ImagesDto images;
}
