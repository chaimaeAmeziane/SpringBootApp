package com.example.project1sttry.Serie;

import com.example.project1sttry.Event.Event;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Serie {
    @Id
    @GeneratedValue
    private int id;
    private String titre;
    private String description;
    @OneToMany
    @JoinColumn(name="serie_id")
    private List<Event> Events = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Event> getEvents() {
        return Events;
    }

    public void setEvents(List<Event> events) {
        Events = events;
    }
}
