package com.dmg.flights.controllers;

import com.dmg.flights.models.Flight;
import com.dmg.flights.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {

    @Autowired
    FlightService service;

    @GetMapping("get/{id}")
    public Flight getPlace(@PathVariable long id){
        return service.getFlight(id);
    }

    @GetMapping("get_all")
    public List<Flight> getAllFlights(){
        return service.getAllFlights();
    }

    @GetMapping("get_by_origin")
    public List<Flight> getFlightsByOrigin(@RequestParam String origin){
        return service.getFlightFilterByOrigin(origin);
    }

    @GetMapping("get_by_origin_date")
    public List<Flight> getFlightsByOriginAndDate(@RequestParam String origin, @RequestParam String date){
        return service.getFlightFilterByOriginAndDate(origin, date);
    }

    @GetMapping("get_by_origin_date_between")
    public List<Flight> getFlightsByOriginAndDateBetween(@RequestParam String origin, @RequestParam String startDate, @RequestParam String endDate){
        return service.getFlightFilterByOriginAndDateBetween(origin, startDate, endDate);
    }
}
