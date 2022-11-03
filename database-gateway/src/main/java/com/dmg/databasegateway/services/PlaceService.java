package com.dmg.databasegateway.services;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.repositories.FlightJpaRepository;
import com.dmg.databasegateway.repositories.PlaceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    private PlaceJpaRepository repository;

    @Autowired
    private FlightJpaRepository flightJpaRepository;


    public List<Place> getAllPlace() {
        return repository.findAll();
    }

    public Place getPlace(long id) {
        Optional<Place> place = repository.findById(id);
        return place.get();
    }

    public Place findPlaceByName(String place){
        return repository.findPlaceByName(place);
    }

    public List<Place> getDestinationsFromOrigin(String origin){
        List<Place> destinations = new ArrayList<>();
        Place place = findPlaceByName(origin);
        List<Flight> flightByOrigin = flightJpaRepository.findFlightByOrigin(place);
        for (Flight flight : flightByOrigin){
            destinations.add(flight.getDestination());
        }
        System.out.println(destinations);
        return destinations.stream().distinct().collect(Collectors.toList());
    }
}
