package com.dmg.databasegateway.controllers;

import com.dmg.databasegateway.models.Reservation;
import com.dmg.databasegateway.models.dto.ReservationDTO;
import com.dmg.databasegateway.services.FlightService;
import com.dmg.databasegateway.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="db_api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private FlightService flightService;

    /*
    * BUG:  org.springframework.http.converter.HttpMessageNotReadableException:
    *       JSON parse error: Cannot construct instance of `com.dmg.databasegateway.models.Flight` (although at least one Creator exists):
    *       no int/Int-argument constructor/factory method to deserialize from Number value (0)
    * REASON: flight_id is a long in Reservation API, but Flight in DB API
    * */

    @GetMapping(path = "/get_all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping(path="/add_one")
    public Reservation addOneFixedReservation(){
       return reservationService.addOneFixedReservation();
    }

    @PostMapping(path = "/add")
    public Reservation makeReservation(@RequestBody ReservationDTO dto){
        Reservation reservation = new Reservation(dto);
        reservation.setFlightId(flightService.getFlight(dto.getFlightId()));
        return reservationService.save(reservation);
    }

    @GetMapping(path="/get/{id}")
    public Reservation getReservation(@PathVariable long id){
        return reservationService.getReservation(id);
    }
}
