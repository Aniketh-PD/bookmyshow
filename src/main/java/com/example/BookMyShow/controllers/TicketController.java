package com.example.BookMyShow.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @GetMapping(path = "/tickets")
    public String getTicket(){
        System.out.println("Request hit the server");
        return "Hello from the server";
    }
}
