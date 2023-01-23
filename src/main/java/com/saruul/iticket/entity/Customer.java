package com.saruul.iticket.entity;

import com.saruul.iticket.form.SignUpForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerSurname;
    private String customerName;
    private String email;
    private String password;


    public static Customer of(SignUpForm signUpForm){
        Customer customer = new Customer();
        customer.setCustomerSurname(signUpForm.getCustomerSurname());
        customer.setCustomerName(signUpForm.getCustomerName());
        customer.setEmail(signUpForm.getEmail());
        customer.setPassword(signUpForm.getPassword());
        return customer;
    }
}
