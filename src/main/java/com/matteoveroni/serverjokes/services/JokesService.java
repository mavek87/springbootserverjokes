package com.matteoveroni.serverjokes.services;

import com.matteoveroni.serverjokes.Joke;
import com.matteoveroni.serverjokes.repository.JokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class JokesService {

    private JokesRepository jokesRepository;
    private Random random = new Random();

    @Autowired
    public JokesService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public Joke generateRandomJoke() {
        int randomJokeIndex = random.nextInt(jokesRepository.getNumberOfJokes());
        return jokesRepository.getJokeByIndex(randomJokeIndex);
    }

    public void addJoke(Joke joke) {
        jokesRepository.addJoke(joke);
    }

    public void removeJoke(int jokeId) {
        jokesRepository.removeJoke(jokeId);
    }

    public Joke getJoke(Integer jokeId) {
        return jokesRepository.getJokeByIndex(jokeId);
    }

    public Collection<Joke> getAllJokes() {
        return jokesRepository.getAllJokes();
    }
}
