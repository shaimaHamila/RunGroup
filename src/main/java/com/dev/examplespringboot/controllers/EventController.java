package com.dev.examplespringboot.controllers;

import com.dev.examplespringboot.dto.EventDto;
import com.dev.examplespringboot.models.Club;
import com.dev.examplespringboot.models.Event;
import com.dev.examplespringboot.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model){
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";

    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId, Model model){
        EventDto event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return"events-detail";
    }
    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model){
        Event newEvent = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", newEvent);
        return "events-create";
    }
    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId,
                              @ModelAttribute("event") EventDto eventDto,
                              Model model,
                              BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("event", eventDto);
            return "events-create";
        }
        eventService.createEvent(clubId,eventDto);
        return "redirect:/clubs/" + clubId;
    }

    @GetMapping("/events/{eventId}/edit")
    public String updateEventForm(@PathVariable("eventId") Long eventId, Model model){
        EventDto event = eventService.findEventById(eventId);
        model.addAttribute("event", event);

        return "events-edit";
    }

    @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long eventId,
                              @Valid @ModelAttribute("event") EventDto event,
                              BindingResult result,
                              Model model){
        if (result.hasErrors()) {
            model.addAttribute("event", event);
            return "events-edit";
        }
        EventDto eventDto = eventService.findEventById(eventId);
        event.setId(eventId);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);
        return "redirect:/events/" + eventId;
    }

    @GetMapping("/events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long eventId){
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }
}
