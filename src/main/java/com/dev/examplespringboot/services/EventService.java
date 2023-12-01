package com.dev.examplespringboot.services;

import com.dev.examplespringboot.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

    List<EventDto> findAllEvents();
}
