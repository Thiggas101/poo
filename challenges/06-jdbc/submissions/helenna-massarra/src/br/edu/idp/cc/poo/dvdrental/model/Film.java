package br.edu.idp.cc.poo.dvdrental.model;

public class Film {
    private int filmId;
    private String title;
    private String description;

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Film(int filmId, String title, String description) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
    }

    public int getFilmId() { return filmId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
}
