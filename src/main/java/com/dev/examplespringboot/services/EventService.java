package com.dev.examplespringboot.services;

import com.dev.examplespringboot.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
    List<EventDto> findAllEvents();
    EventDto findEventById(Long eventId);

    void updateEvent(EventDto event);

    void deleteEvent(Long eventId);
}
