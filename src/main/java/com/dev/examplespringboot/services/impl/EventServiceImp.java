package com.dev.examplespringboot.services.impl;

import com.dev.examplespringboot.dto.EventDto;
import com.dev.examplespringboot.models.Club;
import com.dev.examplespringboot.models.Event;
import com.dev.examplespringboot.repository.ClubRepository;
import com.dev.examplespringboot.repository.EventRepository;
import com.dev.examplespringboot.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.dev.examplespringboot.mapper.EventMapper.mapToEvent;
import static com.dev.examplespringboot.mapper.EventMapper.mapToEventDto;

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

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findEventById(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

}
