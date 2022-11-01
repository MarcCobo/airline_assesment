package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Reservation;
import com.dmg.databasegateway.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="dbapi/reservation")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping(path = "/add")
    public Reservation makeReservation(@RequestBody Reservation reservation){
        System.out.println(reservation);
        return service.save(reservation);
    }
}
