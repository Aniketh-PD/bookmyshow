package com.example.BookMyShow.Dtos;

import com.example.BookMyShow.models.ShowSeat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TicketResponseDto {
    private Long bookingId;
    private Date bookedAt;
    private int ticketNumbersBooked;
    private List<Long> seatNumbers;
    private double amount;
}
