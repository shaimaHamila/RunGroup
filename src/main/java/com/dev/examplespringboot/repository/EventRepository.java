package com.dev.examplespringboot.repository;

import com.dev.examplespringboot.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>{
}
