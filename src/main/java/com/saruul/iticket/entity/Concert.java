package com.saruul.iticket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String concertName;
    private String artistName;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "venueId")
    private Venue venue;
}
