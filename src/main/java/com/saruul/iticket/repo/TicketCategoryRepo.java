package com.saruul.iticket.repo;

import com.saruul.iticket.entity.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCategoryRepo extends JpaRepository<TicketCategory, Long> {
}
