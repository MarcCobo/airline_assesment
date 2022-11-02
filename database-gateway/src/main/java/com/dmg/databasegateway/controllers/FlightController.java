package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "dbapi/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    @GetMapping(path = "/getall")
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }


    @GetMapping(path="/get/{id}")
    public Flight getFlight(@PathVariable long id){
        return service.getFlight(id);
    }

}
