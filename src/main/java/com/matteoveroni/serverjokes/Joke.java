package com.matteoveroni.serverjokes;

public class Joke {
    private String text;

    public Joke() {
    }

    public Joke(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "text='" + text + '\'' +
                '}';
    }
}
