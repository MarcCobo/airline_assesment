package com.dmg.databasegateway.services;

import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.repositories.PlaceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceJpaRepository repository;

    public List<Place> getAllPlace() {
        return repository.findAll();
    }

    public Place getPlace(long id) {
        Optional<Place> place = repository.findById(id);
        return place.get();
    }
}
