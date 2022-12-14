package com.dmg.flights.controllers;

import com.dmg.flights.models.Place;
import com.dmg.flights.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    PlaceService service;

    @CrossOrigin(origins="http://localhost:3000")
    @GetMapping("/get/{id}")
    public Place getPlace(@PathVariable long id){
        return service.getPlace(id);
    }

    @CrossOrigin
    @GetMapping("/get_all")
    public List<Place> getAllPlaces(){
        return service.getAllPlaces();
    }

    @CrossOrigin
    @GetMapping("/get_destinations")
    public List<Place> getDestinations(@RequestParam String origin){
        return service.getDestinations(origin);
    }
}
