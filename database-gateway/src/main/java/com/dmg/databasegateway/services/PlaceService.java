package com.dmg.databasegateway.services;

import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.repositories.PlaceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceJpaRepository repository;
}
