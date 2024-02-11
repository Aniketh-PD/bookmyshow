package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking extends BaseModel{
    @OneToMany
    private List<ShowSeat> showSeatList;

    private Date bookedAt;

    @ManyToOne
    private Show show;
    private double amount;

}
