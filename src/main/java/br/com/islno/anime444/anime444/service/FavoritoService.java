package br.com.islno.anime444.anime444.service;

import br.com.islno.anime444.anime444.dto.AnimeDto;
import br.com.islno.anime444.anime444.model.AnimeFavorito;
import br.com.islno.anime444.anime444.repository.AnimeFavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FavoritoService {

    private final AnimeFavoritoRepository repository;

    @Autowired

    public FavoritoService(AnimeFavoritoRepository repository) {
        this.repository = repository;
    }

    public AnimeFavorito favoritar(AnimeDto animeDto){
        AnimeFavorito novoFavorito = new AnimeFavorito();

        novoFavorito.setTitle(animeDto.getTitle());

        novoFavorito.setScore(animeDto.getScore());

        if(animeDto.getImages() != null && animeDto.getImages().getJpg() != null) {
            novoFavorito.setImageUrl(animeDto.getImages().getJpg().getImageUrl());
        }


        return repository.save(novoFavorito);
    }

    public void deletar (Long id){
     repository.deleteById(id);
    }

    public AnimeFavorito atualizarComentario(Long id, String comentario){
        AnimeFavorito animeParaAtualizar = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anime não encontrado com o id: " + id));

        animeParaAtualizar.setComentario(comentario);

        return repository.save(animeParaAtualizar);
    }

    public List<AnimeFavorito> listarTodos(){
        return repository.findAll();
    }
}