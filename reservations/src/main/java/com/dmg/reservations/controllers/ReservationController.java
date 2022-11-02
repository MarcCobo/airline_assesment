package com.dmg.reservations.controllers;

import com.dmg.reservations.models.ReservationDTO;
import com.dmg.reservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/*
* According to the assessment file, the only thing we have to do
* with reservations is just make them, we do not need to show them or
* anything.
* */

@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {

    @Autowired
    ReservationService service;

    @PostMapping(path = "/add")
    public String makeReservation(@RequestBody ReservationDTO reservation) throws IOException {
        return service.makeReservation(reservation);
    }
}
