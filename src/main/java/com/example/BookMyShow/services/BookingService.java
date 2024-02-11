package com.example.BookMyShow.services;

import com.example.BookMyShow.exceptions.BadRequestException;
import com.example.BookMyShow.models.Booking;
import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.models.ShowSeatStatus;
import com.example.BookMyShow.repositories.BookingRepository;
import com.example.BookMyShow.repositories.ShowSeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    public final BookingRepository bookingRepository;
    private final ShowSeatRepository showSeatRepository;

    public BookingService(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }

    /**
     * start a transaction
     *check the list if it exists in the show_seat table by doing a size check
     * if yes then update the status of the show_seat_status as BLOCKED
     * if no then throw an exception
     * save this data in the show_seats table
     * save this data also in the booking table
     * end the transaction
     */
   @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookShow(List<Long> seatIdList) throws BadRequestException {

        List<ShowSeat> availableSeats = showSeatRepository.findAllById(seatIdList);
        if(availableSeats.size() != seatIdList.size()){
            throw new BadRequestException("Seat not found");
        }

        for(ShowSeat showSeat : availableSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new BadRequestException("Seat not available");
            }
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
        }

        showSeatRepository.saveAll(availableSeats);

        Show show = availableSeats.get(0).getShow();

        Booking booking = Booking.builder()
                        .show(show)
                        .bookedAt(new Date())
                        .showSeatList(availableSeats)
                        .build();

        bookingRepository.save(booking);

        return booking;
    }
}
