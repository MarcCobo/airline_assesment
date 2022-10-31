package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.services.PlaceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="dbapi/place")
public class PlaceController {

    private PlaceService placeService;
/*
    public List<Place> getAllPlaces(){
       return placeService.getAllPlaces();
    }
    */

}
