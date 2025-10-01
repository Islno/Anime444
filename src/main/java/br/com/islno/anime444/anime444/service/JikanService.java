package br.com.islno.anime444.anime444.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JikanService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String JIKAN_API_URL = "https://api.jikan.moe/v4/anime?q=";

    String buscarAnimePorTitulo(String titulo) {
        String url = JIKAN_API_URL + titulo;
        return restTemplate.getForObject(url, String.class);
    }
}
