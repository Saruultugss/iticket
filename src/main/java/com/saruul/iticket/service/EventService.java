package com.saruul.iticket.service;

import com.saruul.iticket.entity.Event;
import com.saruul.iticket.entity.Ticket;
import com.saruul.iticket.entity.TicketCategory;
import com.saruul.iticket.form.EventForm;
import com.saruul.iticket.form.TicketCategoryForm;
import com.saruul.iticket.repo.EventRepo;
import com.saruul.iticket.repo.TicketCategoryRepo;
import com.saruul.iticket.repo.TicketRepo;
import com.saruul.iticket.security.CustomUserDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final EventRepo eventRepo;
    private final TicketCategoryRepo ticketCategoryRepo;
    private final TicketRepo ticketRepo;
    public List<Event> getAllEvent(){
        return eventRepo.findAll();
    }
    public Event getEventById(Long id){
        return eventRepo.findById(id).get();
    }
    public void registerEvent(CustomUserDetails customUserDetails, EventForm eventForm){
        Event event = new Event();
        event.setEventName(eventForm.getEventName());
        event.setEventDate(eventForm.getEventDate());
        event.setEventTime(eventForm.getEventTime());
        event.setDuration(eventForm.getDuration());
        event.setVenueName(eventForm.getVenueName());
        event.setAddress(eventForm.getAddress());
        event.setCategory(eventForm.getCategory());
        event.setCustomer(customUserDetails.getCustomer());
        eventRepo.save(event);
        for (TicketCategoryForm ticketCategoryForm: eventForm.getTicketCategories()) {
            if(ticketCategoryForm.getName() != null && !ticketCategoryForm.getName().isBlank()) {
                TicketCategory ticketCategory = new TicketCategory();

                ticketCategory.setName(ticketCategoryForm.getName());
                ticketCategory.setAmount(ticketCategoryForm.getAmount());
                ticketCategory.setPrice(ticketCategoryForm.getPrice());
                ticketCategory.setMax(ticketCategoryForm.getMax());
                ticketCategory.setEvent(event);
                ticketCategoryRepo.save(ticketCategory);

                if(ticketCategory.getAmount() > 0) {
                    List<Ticket> tickets = new ArrayList<>();
                    for(int i = 0; i < ticketCategory.getAmount(); i++) {
                        Ticket ticket = new Ticket();
                        ticket.setEvent(event);
                        ticket.setTicketCategory(ticketCategory);
                        ticket.setSerialNumber(ticketCategory.getName());
                        tickets.add(ticket);
                    }
                    ticketCategory.setTickets(tickets);
                    ticketRepo.saveAll(tickets);
                }
            }
        }
    }

}
