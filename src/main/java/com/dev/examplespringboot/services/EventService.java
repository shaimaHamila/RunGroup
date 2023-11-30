package com.dev.examplespringboot.services;

import com.dev.examplespringboot.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
}
