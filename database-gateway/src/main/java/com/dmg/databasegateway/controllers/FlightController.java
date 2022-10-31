package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FlightController {

    @Autowired
    private FlightService service;
}
