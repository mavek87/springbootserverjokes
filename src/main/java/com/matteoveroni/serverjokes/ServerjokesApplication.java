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
		jokesRepository.addJoke(new Joke("First joke"));
		jokesRepository.addJoke(new Joke("Second joke"));
		jokesRepository.addJoke(new Joke("Third joke"));
		jokesRepository.addJoke(new Joke("Fourth joke"));
		jokesRepository.addJoke(new Joke("Fifth joke"));
	}
}
