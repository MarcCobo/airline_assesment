package com.dmg.databasegateway.services;

import com.dmg.databasegateway.repositories.ReservationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationJpaRepository repository;
}
