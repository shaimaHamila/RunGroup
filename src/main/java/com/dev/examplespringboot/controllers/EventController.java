package com.dev.examplespringboot.controllers;

import com.dev.examplespringboot.dto.EventDto;
import com.dev.examplespringboot.models.Event;
import com.dev.examplespringboot.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model){
        Event newEvent = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", newEvent);
        return "events-create";
    }
    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, @ModelAttribute("event") EventDto eventDto, Model model){
        eventService.createEvent(clubId,eventDto);
        return "redirect:/clubs/" + clubId;
    }
}
