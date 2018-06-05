package com.matteoveroni.serverjokes;

import com.matteoveroni.serverjokes.repository.JokesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServerjokesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ServerjokesApplication.class, args);
		JokesRepository jokesRepository = (JokesRepository) ctx.getBean("jokesRepository");
		popolaJokesRepository(jokesRepository);
	}

	private static void popolaJokesRepository(JokesRepository jokesRepository) {
		jokesRepository.addJoke(new Joke("Primo joke"));
		jokesRepository.addJoke(new Joke("Secondo joke"));
		jokesRepository.addJoke(new Joke("Terzo joke"));
		jokesRepository.addJoke(new Joke("Quarto joke"));
		jokesRepository.addJoke(new Joke("Quinto joke"));
	}
}
