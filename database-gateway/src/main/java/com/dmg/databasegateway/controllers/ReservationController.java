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

    /*
    * BUG:  org.springframework.http.converter.HttpMessageNotReadableException:
    *       JSON parse error: Cannot construct instance of `com.dmg.databasegateway.models.Flight` (although at least one Creator exists):
    *       no int/Int-argument constructor/factory method to deserialize from Number value (0)
    * REASON: flight_id is a long in Reservation API, but Flight in DB API
    * */
    @PostMapping(path = "/add")
    public Reservation makeReservation(@RequestBody Reservation reservation){
        System.out.println(reservation);
        return service.save(reservation);
    }
}
