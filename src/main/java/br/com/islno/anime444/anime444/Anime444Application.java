package br.com.islno.anime444.anime444;

// Imports que estão sendo realmente usados
import br.com.islno.anime444.anime444.dto.AnimeDto;
import br.com.islno.anime444.anime444.dto.JikanResponseDto;
import br.com.islno.anime444.anime444.service.JikanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Anime444Application {

	public static void main(String[] args) {
		SpringApplication.run(Anime444Application.class, args);
	}

	@Bean
	public CommandLineRunner run(JikanService jikanService) {
		return args -> {
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("\n==================================");
				System.out.println("Digite um anime ou 'sair' para encerrar");
				String linha = scanner.nextLine();

				// Sugestão: usar equalsIgnoreCase para aceitar "sair", "Sair", "SAIR", etc.
				if ("sair".equalsIgnoreCase(linha)) {
					break;
				}

				JikanResponseDto resposta = jikanService.buscarAnimePorTitulo(linha);
				List<AnimeDto> animes = resposta.getData();

				if (animes == null || animes.isEmpty()) {
					System.out.println("Nenhum anime encontrado com esse título.");
				} else {
					System.out.println("------------ Animes Encontrados ------------------------");
					for (AnimeDto anime : animes) {
						System.out.println("\nTítulo: " + anime.getTitle());
						System.out.println("Episódios: " + anime.getEpisodes());
						System.out.println("Nota: " + anime.getScore());
						System.out.println("------------------------------------------------------");
					}
				}
			}
			System.out.println("Encerrando a aplicação. Até logo!");
		};
	}
}