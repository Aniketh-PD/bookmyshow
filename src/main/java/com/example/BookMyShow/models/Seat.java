package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

@Entity
public class Seat extends  BaseModel{
    private int seatNumber;
    private char rowNum;
    private int columnNum;

    @Enumerated
    private SeatType seatType;
}
