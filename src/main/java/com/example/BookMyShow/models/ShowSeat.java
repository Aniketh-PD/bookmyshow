package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeat extends BaseModel {

    @ManyToOne
    private Show show;
    @Enumerated
    private ShowSeatStatus showSeatStatus;
    @ManyToOne
    private Seat seat;

    private double price;

}
