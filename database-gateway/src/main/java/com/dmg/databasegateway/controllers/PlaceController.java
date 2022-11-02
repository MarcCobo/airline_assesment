package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="dbapi/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping(path="/getall")
    public List<Place> getAllPlace(){
        return placeService.getAllPlace();
    }

    @GetMapping(path="/get/{id}")
    public Place getPlace(@PathVariable long id){
        return placeService.getPlace(id);
    }



}
