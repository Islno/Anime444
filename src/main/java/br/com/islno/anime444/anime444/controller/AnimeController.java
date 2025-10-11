package br.com.islno.anime444.anime444.controller;

import br.com.islno.anime444.anime444.dto.JikanResponseDto;
import br.com.islno.anime444.anime444.service.JikanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.islno.anime444.anime444.dto.AnimeDto;
import br.com.islno.anime444.anime444.model.AnimeFavorito;
import br.com.islno.anime444.anime444.service.FavoritoService;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/animes")
@CrossOrigin(origins = "*")
public class AnimeController {
    private final JikanService jikanService;
    private final FavoritoService favoritoService;

    @Autowired

    public AnimeController(JikanService jikanService, FavoritoService favoritoService) {
        this.jikanService = jikanService;
        this.favoritoService = favoritoService;
    }

    @GetMapping("/buscar")
    public JikanResponseDto buscar(@RequestParam String titulo) {
        return jikanService.buscarAnimePorTitulo(titulo);
    }

    @PostMapping("/favoritar")
    @ResponseStatus(HttpStatus.CREATED)
    public AnimeFavorito favoritar(@RequestBody AnimeDto animeDto){
        return favoritoService.favoritar(animeDto);
    }

    @GetMapping("/favoritos")
    public List<AnimeFavorito> listarFavoritos(){

        return favoritoService.listarTodos();
    }
}