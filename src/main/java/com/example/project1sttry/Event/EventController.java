package com.example.project1sttry.Event;

import com.example.project1sttry.Serie.Serie;
import com.example.project1sttry.Serie.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private SerieService sservice;

    @Autowired
    private EventService eservice;

    @GetMapping("/series/{id}")
    public String showEventsOfSpecificSerie(@PathVariable("id") Integer id, Model model)
    {
        List<Event> listeEvent = eservice.findAllByIdEvent(id);
        model.addAttribute("list_specified_events",listeEvent);
        return "List_events";
    }
    @GetMapping("/series/{id}/event/new")
    public String addNewEventToASerie(@PathVariable("id") Integer id,Model model)
    {
        model.addAttribute("event",new Event());
        return "Add_Event";
    }
    @PostMapping("/series/{id}/event/new/save")
    public String SaveNewEvent(@PathVariable("id") Integer id, Event event)
    {
        event.setSerie(sservice.getSerieById(id));
        eservice.saveEvent(event);
        return "redirect:/series/{id}";
    }
    @GetMapping("/series/{id}/event/edit/{eid}")
    public String EditEvent(@PathVariable("id") Integer id, @PathVariable("eid") Integer eid,Model model)
    {
        model.addAttribute("event",eservice.getEventById(eid));
        return "Edit_Event";
    }
    @PostMapping("/series/{id}/event/edit/{eid}/save")
    public String SaveEditEvent(@PathVariable("id") Integer id, @PathVariable("eid") Integer eid,Event event)
    {
        event.setSerie(sservice.getSerieById(id));
        eservice.saveEvent(event);
        return "redirect:/series/{id}";
    }
    @GetMapping("/series/{id}/event/delete/{eid}")
    public String DeleteEvent(@PathVariable("id") Integer id, @PathVariable("eid") Integer eid)
    {
        eservice.deleteEvent(eid);
        return "redirect:/series/{id}";
    }
}



