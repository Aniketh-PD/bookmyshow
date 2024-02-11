package com.example.BookMyShow.Dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequestDto {
    private List<Long> showSeatIds;
}
