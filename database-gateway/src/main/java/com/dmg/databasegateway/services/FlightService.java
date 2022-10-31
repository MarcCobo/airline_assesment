package com.dmg.databasegateway.services;

import com.dmg.databasegateway.repositories.FlightJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private FlightJpaRepository repository;
}
