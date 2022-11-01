package com.dmg.reservations.controllers;

import com.dmg.reservations.models.Reservation;
import com.dmg.reservations.services.ReservationService;
import io.restassured.response.Response;
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

    @PostMapping(path = "/reservation/add")
    public Response makeReservation(@RequestBody Reservation reservation) {
        return service.makeReservation(reservation);
    }
}
