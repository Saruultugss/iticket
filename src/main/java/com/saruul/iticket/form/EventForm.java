package com.saruul.iticket.form;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventForm {
    private String eventName;
    private String category;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private int duration;
    private String venueName;
    private String address;
    private List<TicketCategoryForm> ticketCategories;

    public EventForm() {
        this.ticketCategories = new ArrayList<>();
    }
}
