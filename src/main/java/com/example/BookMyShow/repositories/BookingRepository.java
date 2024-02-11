package com.example.BookMyShow.repositories;

import com.example.BookMyShow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
