package com.dmg.reservations.services;

import com.dmg.reservations.models.Reservation;
import com.dmg.reservations.models.ReservationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
        System.out.println(rev);
        ReservationDTO dto = new ReservationDTO(rev);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return given().log().all().body((Object) dto, (io.restassured.mapper.ObjectMapper) mapper).contentType(ContentType.JSON).when().post(BASE_URI + "/add");
    }

    /*
    * Maybe we need something here for the price. Like, if you are over 9 years old
    * it changes and all that stuff.
    * */
}
