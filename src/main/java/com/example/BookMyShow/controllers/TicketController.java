package com.example.BookMyShow.controllers;

import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.repositories.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {

    public TicketController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepository movieRepository;

    @GetMapping(path = "/book")
    public String bookTicket(){
        System.out.println("Request hit the server");
        movieRepository.save(Movie.builder().Id(1l).name("The Intern").language("ENGLISH").build());
        return "Hello from the server";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/get")
    public void getTickets(){
        System.out.println(movieRepository.findAll());
    }
}
