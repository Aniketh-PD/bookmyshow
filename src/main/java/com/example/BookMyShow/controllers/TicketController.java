package com.example.BookMyShow.controllers;

import com.example.BookMyShow.Dtos.TicketRequestDto;
import com.example.BookMyShow.Dtos.TicketResponseDto;
import com.example.BookMyShow.models.Booking;
import com.example.BookMyShow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {

    public final BookingService bookingService;

    @Autowired
    public TicketController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(path = "/book")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody TicketResponseDto bookTicket(@RequestBody TicketRequestDto ticketRequestDto){

        Booking booking =  bookingService.bookShow(ticketRequestDto.getShowSeatIds());

        TicketResponseDto ticketResponseDto = TicketResponseDto
                                                .builder()
                                                .bookingId(booking.getId())
                                                .bookedAt(booking.getBookedAt())
                                                .ticketNumbersBooked(booking.getShowSeatList().size())
                                                .build();
        return ticketResponseDto;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/get")
    public void getTickets(){
        System.out.println("Hello from the server");
    }
}
