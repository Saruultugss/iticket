package com.saruul.iticket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private int duration;
    private String venueName;
    private String address;
    private boolean online;
    private String category;
    @ManyToOne
    @JoinColumn(name = "createdBy")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "eventId")
    private List<TicketCategory> ticketCategories;
}
