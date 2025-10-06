package br.com.islno.anime444.anime444.controller;

import br.com.islno.anime444.anime444.service.JikanService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animes")
public class AnimeController {
    private final JikanService jikanService;

    @Autowired
    public AnimeController(JikanService jikanService) {
        this.jikanService = jikanService;
    }

    @GetMapping("/buscar")
    public String buscarAnime(@RequestParam String titulo){
        return jikanService.buscarAnimePorTitulo(titulo);
        
    }

}
