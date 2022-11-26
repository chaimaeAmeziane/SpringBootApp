package com.example.project1sttry.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    @Query( value = "SELECT * from event where serie_id = :id",
            nativeQuery = true)
    public List<Event> findEventsBySerieId(@Param("id") Integer id);
}
