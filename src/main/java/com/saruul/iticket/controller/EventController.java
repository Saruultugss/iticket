package com.saruul.iticket.controller;

import com.saruul.iticket.entity.Event;
import com.saruul.iticket.form.EventForm;
import com.saruul.iticket.form.EventSearchForm;
import com.saruul.iticket.form.TicketCategoryForm;
import com.saruul.iticket.security.CustomUserDetails;
import com.saruul.iticket.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/event")
    public String event(EventSearchForm eventSearchForm, Model model) {
        if(eventSearchForm == null){
            eventSearchForm = new EventSearchForm();
        }
        List<Event> events = eventService.getAllEvent();
        model.addAttribute("eventList", events);
        model.addAttribute("eventSearchForm", eventSearchForm);
        return "events";
    }
    @GetMapping("/event/create")
    public String create(Model model) {
        return "create";
    }

    @GetMapping("/event/create-form")
    public String createForm(Model model) {
        EventForm eventForm = new EventForm();
        for(int i = 0; i < 3;i++) {
            eventForm.getTicketCategories().add(new TicketCategoryForm());
        }
        model.addAttribute("eventForm", eventForm);
        return "create-form";
    }

    @PostMapping("/event/create-form/register")
    public String register(@AuthenticationPrincipal CustomUserDetails customUserDetails, EventForm eventForm) {
        eventService.registerEvent(customUserDetails, eventForm);
        return "redirect:/";
    }

    @GetMapping("/event/{id}/detail")
    public String eventDetail(@PathVariable Long id, Model model){
        model.addAttribute("event", eventService.getEventById(id));
        return "event-detail";
    }

    @GetMapping("/event/ticket/buy")
    public String register(){
        return "Buy ticket here";
    }

}
