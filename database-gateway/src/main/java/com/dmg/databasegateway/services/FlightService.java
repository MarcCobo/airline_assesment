package com.dmg.databasegateway.services;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.repositories.FlightJpaRepository;
import com.dmg.databasegateway.repositories.PlaceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightJpaRepository repository;
    @Autowired
    private PlaceJpaRepository placeRepository;

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }


    public Flight getFlight(long id) {
        Optional<Flight> flight = repository.findById(id);
        return flight.get();
    }
}
