package com.dmg.reservations.services;

import com.dmg.reservations.models.Reservation;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
public class ReservationService {

    public static String BASE_URI = "http://localhost:8080/dbapi";

    public int makeReservation(Reservation rev) {
        return given().body(rev).when().post(BASE_URI).statusCode();
    }

    /*
    * Maybe we need something here for the price. Like, if you are over 9 years old
    * it changes and all that stuff.
    * */
}
