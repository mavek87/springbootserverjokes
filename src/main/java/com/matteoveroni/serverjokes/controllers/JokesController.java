package com.matteoveroni.serverjokes.controllers;

import com.matteoveroni.serverjokes.Joke;
import com.matteoveroni.serverjokes.services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class JokesController {

    private static final String CLASS_TAG = JokesController.class.getSimpleName();
    private static final String JOKES_URL = "/jokes";

    private final JokesService jokesService;

    @Autowired
    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping(value = JOKES_URL + "/random", method = GET, produces = "application/json")
    public Joke getRandomJoke() {
        return jokesService.generateRandomJoke();
    }

    @RequestMapping(value = JOKES_URL, method = GET, produces = "application/json")
    public Collection<Joke> getAllTheJokes() {
        return jokesService.getAllJokes();
    }

    @RequestMapping(value = JOKES_URL, method = POST, consumes = "application/json", produces = "application/json")
    public Joke addJoke(@RequestBody Joke joke) {
        if (joke != null) {
            System.out.println(CLASS_TAG + " - Add joke: " + joke.toString());
            jokesService.addJoke(joke);
        }
        return joke;
    }

    @RequestMapping(value = {JOKES_URL + "/{id}"}, method = DELETE, produces = "application/json")
    public void deleteJoke(@PathParam("id") Integer jokeId) {
        System.out.println(CLASS_TAG + " - Delete joke: " + jokesService.getJoke(jokeId));
        jokesService.removeJoke(jokeId);
    }
}
