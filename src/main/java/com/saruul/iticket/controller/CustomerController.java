package com.saruul.iticket.controller;

import com.saruul.iticket.entity.Customer;
import com.saruul.iticket.form.SignUpForm;
import com.saruul.iticket.security.CustomUserDetails;
import com.saruul.iticket.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping("/customer/sign-in")
    public String signIn(){
        return "customer/sign-in";
    }
    @GetMapping("/customer/sign-up")
    public String signUp(){
        return "customer/sign-up";
    }
    @PostMapping("/customer/sign-up")
    public String register(SignUpForm signUpForm) {
        customerService.signUp(signUpForm);
        return "customer/sign-in";
    }
    @PreAuthorize("isAuthenticated() && #id == authentication.principal.customer.id")
    @GetMapping("/customer/{id}/profile")
    public String customerProfile(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/profile";
    }

}
