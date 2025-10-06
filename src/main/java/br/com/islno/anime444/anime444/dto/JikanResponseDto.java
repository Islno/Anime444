package br.com.islno.anime444.anime444.dto;

import lombok.Data;
import java.util.List;

@Data
public class JikanResponseDto {
    private List<AnimeDto> data;
}
