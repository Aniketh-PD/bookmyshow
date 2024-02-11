package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity(name = "movie_show")
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

    @OneToMany
    private List<ShowSeat> showSeatList;
}
