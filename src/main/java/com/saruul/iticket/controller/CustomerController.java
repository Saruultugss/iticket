package com.saruul.iticket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    @GetMapping("/customer/sign-in")
    public String signIn(){
        return "customer/sign-in";
    }
    @GetMapping("/customer/sign-up")
    public String signUp(){
        return "customer/sign-up";
    }
}
