package com.saruul.iticket.controller;

import com.saruul.iticket.entity.Concert;
import com.saruul.iticket.repo.ConcertRepo;
import com.saruul.iticket.service.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ConcertService concertService;
    @GetMapping("/concerts")
    public String index(Model model) {
        List<Concert> concerts = concertService.getAllConcert();
        System.out.println(concerts.size());
        model.addAttribute("concertList", concerts);
        return "index";
    }
}
