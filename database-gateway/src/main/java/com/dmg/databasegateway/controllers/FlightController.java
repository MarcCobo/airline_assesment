package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.dto.FlightDTO;
import com.dmg.databasegateway.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "dbapi/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    //Entities

    @GetMapping(path = "/getall")
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping(path = "/get/{id}")
    public Flight getFlight(@PathVariable long id) {
        return service.getFlight(id);
    }

    //DTOs

    @GetMapping(path = "/getalldto")
    public List<FlightDTO> getAllFlightsDTO() {
        List<FlightDTO> flightDTOS = new ArrayList<>();
        service.getAllFlights().stream().map(flight -> flightDTOS.add(new FlightDTO(flight.getId(), flight.getAirline(),
                flight.getFlight_num(), flight.getOrigin().getId(),
                flight.getDestination().getId(), flight.getDate(), flight.getPrice(), flight.getLayover(),
                flight.getLayover_text(), flight.isLuggage(), flight.getTransit_time())));
        System.out.println(flightDTOS);
        return flightDTOS;
    }

    @GetMapping(path = "/getdto/{id}")
    public FlightDTO getFlightDTO(@PathVariable long id) {
        Flight flight = service.getFlight(id);
        return new FlightDTO(flight.getId(), flight.getAirline(), flight.getFlight_num(), flight.getOrigin().getId(),
                flight.getDestination().getId(), flight.getDate(), flight.getPrice(), flight.getLayover(),
                flight.getLayover_text(), flight.isLuggage(), flight.getTransit_time());
    }
}
