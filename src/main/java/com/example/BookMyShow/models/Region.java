package com.example.BookMyShow.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Region extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "region")
    private List<Theatre> theatreList;
    private  double longitude;
    private double latitude;
}
