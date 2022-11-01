package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.Reservation;
import com.dmg.databasegateway.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/getall")
    public List<Reservation> getAllReservations() {
        return service.getAllReservations();
    }

    @PostMapping(path="/addone")
    public Reservation addOneFixedReservation(){
       return service.addOneFixedReservation();
    }

    @PostMapping(path = "/add")
    public Reservation makeReservation(@RequestBody Reservation reservation){
        System.out.println(reservation);
        return service.save(reservation);
    }

    @GetMapping(path="/get/{id}")
    public Reservation getReservation(@PathVariable long id){
        return service.getReservation(id);
    }
}
