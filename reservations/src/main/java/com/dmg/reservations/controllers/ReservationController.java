package com.dmg.reservations.controllers;

import com.dmg.reservations.models.Reservation;
import com.dmg.reservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
* According to the assessment file, the only thing we have to do
* with reservations is just make them, we do not need to show them or
* anything.
* */

@RestController
public class ReservationController {

    @Autowired
    ReservationService service;

    @PostMapping(path = "/reservations")
    public int makeReservation(@RequestBody Reservation reservation) {
        return service.makeReservation(reservation);
    }
}
