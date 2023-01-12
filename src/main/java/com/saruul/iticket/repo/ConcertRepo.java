package com.saruul.iticket.repo;

import com.saruul.iticket.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepo extends JpaRepository<Concert, Long> {
}
