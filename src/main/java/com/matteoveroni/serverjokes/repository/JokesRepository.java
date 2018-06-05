package com.matteoveroni.serverjokes.repository;

import com.matteoveroni.serverjokes.Joke;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JokesRepository {

    private final static Map<Integer, Joke> jokes = new HashMap<>();
    private static int ID_COUNTER = 0;

    public void addJoke(Joke joke) {
        jokes.put(ID_COUNTER, joke);
        ID_COUNTER++;
    }

    public void removeJoke(int jokeId) {
        jokes.remove(jokeId);
        ID_COUNTER--;
    }

    public Joke getJokeByIndex(int index) {
        return jokes.get(index);
    }

    public int getNumberOfJokes() {
        return jokes.values().size();
    }

    public Collection<Joke> getAllJokes() {
        return jokes.values();
    }
}
