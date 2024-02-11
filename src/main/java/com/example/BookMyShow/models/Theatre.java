package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Theatre extends BaseModel{
    private String name;


    @ManyToOne
    private Region region;
}
