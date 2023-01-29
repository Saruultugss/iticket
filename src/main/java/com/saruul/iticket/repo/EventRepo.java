package com.saruul.iticket.repo;

import com.saruul.iticket.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {

    public List<Event> findByOnline(boolean online);

    public List<Event> findByCategory(String category);

    public List<Event> findByCategoryAndOnline(String category, boolean online);
}
