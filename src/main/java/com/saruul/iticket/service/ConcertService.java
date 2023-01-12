package com.saruul.iticket.service;

import com.saruul.iticket.entity.Concert;
import com.saruul.iticket.repo.ConcertRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ConcertService {

    private final ConcertRepo concertRepo;
    public List<Concert> getAllConcert(){
        return concertRepo.findAll();
    }
}
