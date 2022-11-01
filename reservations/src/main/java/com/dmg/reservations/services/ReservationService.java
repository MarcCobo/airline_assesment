package com.dmg.reservations.services;

import com.dmg.reservations.models.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Service
public class ReservationService {

    public static String BASE_URI = "http://localhost:8080/dbapi/reservation";

    public Response makeReservation(Reservation rev) {
        ObjectMapper Obj = new ObjectMapper();
        return given().log().all().body(rev).contentType(ContentType.JSON).when().post(BASE_URI + "/add");
    }

    /*
    * Maybe we need something here for the price. Like, if you are over 9 years old
    * it changes and all that stuff.
    * */
}
