package br.com.islno.anime444.anime444.repository;

import br.com.islno.anime444.anime444.model.AnimeFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeFavoritoRepository extends JpaRepository<AnimeFavorito, Long> {

}