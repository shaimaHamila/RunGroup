package com.dev.examplespringboot.mapper;

import com.dev.examplespringboot.dto.EventDto;
import com.dev.examplespringboot.models.Event;

public class EventMapper {


    public static Event mapToEvent(EventDto eventDto){
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
    public static EventDto mapToEventDto(Event event){
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
