package com.dmg.reservations.controllers;

import com.dmg.reservations.models.ReservationDTO;
import com.dmg.reservations.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public ResponseEntity<ReservationDTO> makeReservation(@RequestBody ReservationDTO reservation) throws IOException {
        return service.makeReservation(reservation);
    }

    @CrossOrigin
    @GetMapping(path = "/get_variable_price")
    public double getVariablePrice(@RequestParam(name = "ages") List<Integer> ages,
                                   @RequestParam(name = "bags") boolean bags, @RequestParam(name = "price") double price) {
        System.out.println(ages);
        return service.getVariablePrice(ages.stream().mapToInt(i->i).toArray(), bags, price);
    }
}
