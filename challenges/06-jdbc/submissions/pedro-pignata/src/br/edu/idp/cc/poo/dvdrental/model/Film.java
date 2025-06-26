package br.edu.idp.cc.poo.dvdrental.model;

import java.time.Year;

public class Film {
    private int id;
    private String title;
    private String description;
    private Year releaseYear;
    
    public Film() {}

    public Film(int id, String title, String description, Year releaseYear) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }
    
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }
    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }
    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }
    public Year getReleaseYear() { 
        return releaseYear; 
    }
    public void setReleaseYear(Year releaseYear) { 
        this.releaseYear = releaseYear; 
    }

    @Override
    public String toString() {
        return String.format("Filme #%d: %s (%d)", id, title, releaseYear.getValue());
    }
}