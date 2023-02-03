package com.saruul.iticket.service;

import com.saruul.iticket.entity.Customer;
import com.saruul.iticket.form.SignUpForm;
import com.saruul.iticket.repo.CustomerRepo;
import com.saruul.iticket.security.CustomUserDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class CustomerService implements UserDetailsService {

    private final CustomerRepo customerRepo;

    public void signUp(SignUpForm signUpForm){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signUpForm.getPassword());
        signUpForm.setPassword(encodedPassword);
        customerRepo.save(Customer.of(signUpForm));
    }

    public Customer getCustomerById(Long id){
        return customerRepo.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepo.findByEmail(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(customer);
    }
}
