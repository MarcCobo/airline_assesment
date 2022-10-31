package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ReservationController {

    @Autowired
    private ReservationService service;
}
