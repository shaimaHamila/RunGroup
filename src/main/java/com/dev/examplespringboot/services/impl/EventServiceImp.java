package com.dev.examplespringboot.services.impl;

import com.dev.examplespringboot.dto.EventDto;
import com.dev.examplespringboot.models.Club;
import com.dev.examplespringboot.models.Event;
import com.dev.examplespringboot.repository.ClubRepository;
import com.dev.examplespringboot.repository.EventRepository;
import com.dev.examplespringboot.services.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImp implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    EventServiceImp(EventRepository eventRepository, ClubRepository clubRepository){
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }
    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event newEvent = mapToEvent(eventDto);
        newEvent.setClub(club);
        eventRepository.save(newEvent);
    }


    public Event mapToEvent(EventDto eventDto){
        Event event = Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .photoURL(eventDto.getPhotoURL())
                .type(eventDto.getType())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .updatedOn(eventDto.getUpdatedOn())
                .creationOn(eventDto.getCreationOn())
                .build();
        return event;
    }
    public EventDto mapToEventDto(Event event){
        EventDto eventDto = EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .type(event.getType())
                .photoURL(event.getPhotoURL())
                .creationOn(event.getCreationOn())
                .updatedOn(event.getUpdatedOn())
                .endTime(event.getEndTime())
                .startTime(event.getStartTime())
                .build();
        return eventDto;
    }
}
