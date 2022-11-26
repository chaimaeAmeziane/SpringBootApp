package com.example.project1sttry.Event;

import com.example.project1sttry.Serie.Serie;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository erepo;

    public Event saveEvent(Event event)
    {

        return erepo.save(event);
    }
    public List<Event> showEvents()
    {

        return erepo.findAll();
    }
    public Event getEventById(int id)
    {

        return (Event) erepo.findById(id).orElse(null);
    }
    public String deleteEvent(int id)
    {
        erepo.deleteById(id);
        return "Event deleted";
    }
    public List<Event> findAllByIdEvent(int id)
    {
        return erepo.findEventsBySerieId(id);
    }

}
