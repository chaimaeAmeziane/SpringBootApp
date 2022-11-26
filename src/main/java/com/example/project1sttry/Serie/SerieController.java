package com.example.project1sttry.Serie;

import com.example.project1sttry.Event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SerieController {

    @Autowired
    private SerieService serieservice;

    @GetMapping("/series")
    public String listAllSeries(Model model)
    {
        model.addAttribute("listofseries",serieservice.showSeries());
        return "List_series";
    }
    @GetMapping("/series/new")
    public String AddNewSerie(Model model)
    {
        model.addAttribute("serie",new Serie());
        return "Add_serie";
    }
    @PostMapping("/series/save")
    public String SaveNewSeries(Serie serie)
    {
       serieservice.saveSerie(serie);
       return "redirect:/series";
    }
    @GetMapping("/series/edit/{id}")
    public String editSeries(@PathVariable("id") Integer id,Model model)
    {
        model.addAttribute("serie", serieservice.getSerieById(id));
        //List<Event> listeEvent = serieservice.getSerieById(id).getEvents();
        //model.addAttribute("listEvent",listeEvent);
        return "Add_serie";
    }

}
