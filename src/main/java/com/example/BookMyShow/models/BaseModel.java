package com.example.BookMyShow.models;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
}
