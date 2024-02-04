package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "movies")
public class Movie {

    @Id
    private Long Id;
    private String name;
    private String language;
    private double rating;
    private int duration;
    private String category;
}
