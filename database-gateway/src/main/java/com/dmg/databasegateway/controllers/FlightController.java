package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.dto.FlightDTO;
import com.dmg.databasegateway.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "db_api/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    //Entities

    @GetMapping(path = "/get_all")
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @GetMapping(path = "/get/{id}")
    public Flight getFlight(@PathVariable long id) {
        return service.getFlight(id);
    }

    //DTOs

    @GetMapping(path = "/get_all_dto")
    public List<FlightDTO> getAllFlightsDTO() {
        List<FlightDTO> flightDTOS = new ArrayList<>();
        for(Flight flight : service.getAllFlights()){
            flightDTOS.add(new FlightDTO(flight.getId(), flight.getAirline(),
                flight.getFlight_num(), flight.getOrigin().getId(),
                flight.getDestination().getId(), flight.getDate(), flight.getPrice(), flight.getLayover(),
                flight.getLayover_text(), flight.isLuggage(), flight.getTransit_time()));
        }
        return flightDTOS;
    }

    @GetMapping(path = "/get_dto/{id}")
    public FlightDTO getFlightDTO(@PathVariable long id) {
        Flight flight = service.getFlight(id);
        return new FlightDTO(flight.getId(), flight.getAirline(), flight.getFlight_num(), flight.getOrigin().getId(),
                flight.getDestination().getId(), flight.getDate(), flight.getPrice(), flight.getLayover(),
                flight.getLayover_text(), flight.isLuggage(), flight.getTransit_time());
    }

    @GetMapping(path = "/get_dto/origin_and_date")
    public List<FlightDTO> getFilteredFlightsByOriginAndDateDTO(@RequestParam String origin, @RequestParam LocalDate date){
        List<FlightDTO> flightDTOS = new ArrayList<>();
        for(Flight flight : service.getFlightsFilterByOriginAndDate(origin, date)){
            flightDTOS.add(new FlightDTO(flight.getId(), flight.getAirline(),
                    flight.getFlight_num(), flight.getOrigin().getId(),
                    flight.getDestination().getId(), flight.getDate(), flight.getPrice(), flight.getLayover(),
                    flight.getLayover_text(), flight.isLuggage(), flight.getTransit_time()));
        }
        return flightDTOS;
    }

    @GetMapping(path = "/get_dto/origin_and_date_between")
    public List<FlightDTO> getFilteredFlightsByOriginAndDateBetweenDTO(@RequestParam String origin, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        List<FlightDTO> flightDTOS = new ArrayList<>();
        for(Flight flight : service.getFlightsFilterByOriginAndDateBetween(origin, startDate, endDate)){
            flightDTOS.add(new FlightDTO(flight.getId(), flight.getAirline(),
                    flight.getFlight_num(), flight.getOrigin().getId(),
                    flight.getDestination().getId(), flight.getDate(), flight.getPrice(), flight.getLayover(),
                    flight.getLayover_text(), flight.isLuggage(), flight.getTransit_time()));
        }
        return flightDTOS;
    }
}
