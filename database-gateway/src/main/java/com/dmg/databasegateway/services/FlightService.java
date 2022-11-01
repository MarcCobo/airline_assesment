package com.dmg.databasegateway.services;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.repositories.FlightJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private FlightJpaRepository repository;

    public Flight save(Flight flight){
        return repository.save(flight);
    }
}
