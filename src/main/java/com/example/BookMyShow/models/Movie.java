package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "movies")
public class Movie extends BaseModel{

    private String name;
    private String language;
    private double rating;
    private int duration;
    private String category;

    @Override
    public String toString() {
        return "Movie{" +
                "Id=" + this.getId() +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", rating=" + rating +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                '}';
    }
}
