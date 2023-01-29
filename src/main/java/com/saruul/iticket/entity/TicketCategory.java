package com.saruul.iticket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer amount;
    private Integer price;
    private Integer max;
    private String description;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;

    @OneToMany
    @JoinColumn(name = "ticketCategoryId")
    private List<Ticket> tickets;
}
