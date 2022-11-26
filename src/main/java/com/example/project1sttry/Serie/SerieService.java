package com.example.project1sttry.Serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SerieService {
    @Autowired
    private SerieRepository srepo;

    public Serie saveSerie(Serie serie)
    {
        return (Serie) srepo.save(serie);
    }
    public List<Serie> showSeries()
    {
        return srepo.findAll();
    }
    public Serie getSerieById(int id)
    {
        return (Serie) srepo.findById(id).orElse(null);
    }
    public String deleteProduct(int id)
    {
        srepo.deleteById(id);
        return "Serie deleted";
    }
}
