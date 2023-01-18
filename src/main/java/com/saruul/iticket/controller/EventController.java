package com.saruul.iticket.controller;

import com.saruul.iticket.entity.Concert;
import com.saruul.iticket.service.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final ConcertService concertService;
    @GetMapping("/concert/create")
    public String create(Model model) {
        List<Concert> concerts = concertService.getAllConcert();
        System.out.println(concerts.size());
        model.addAttribute("concertList", concerts);
        return "create";
    }

    @GetMapping("/concert/create-form")
    public String createForm(Model model) {
        List<Concert> concerts = concertService.getAllConcert();
        System.out.println(concerts.size());
        model.addAttribute("concertList", concerts);
        return "create-form";
    }

    @PostMapping("/concert/create-form/register")
    public String register(Model model) {
        return "redirect:/";
    }

    @GetMapping("/concert/ticket/buy")
    public String register(){
        return "Buy ticket here";
    }

}
