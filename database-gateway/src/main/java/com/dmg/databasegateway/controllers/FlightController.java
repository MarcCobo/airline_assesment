package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="dbapi/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping(path = "/add")
    public Flight addFlight(@RequestBody Flight flight){
        return service.save(flight);
    }
}
