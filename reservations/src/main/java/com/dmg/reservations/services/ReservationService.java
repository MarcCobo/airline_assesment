package com.dmg.reservations.services;

import com.dmg.reservations.models.ReservationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;
import org.springframework.stereotype.Service;


import java.io.*;

import static io.restassured.RestAssured.given;

@Service
public class ReservationService {

    public String BASE_URI = "http://localhost:8080/db_api/reservation/add";

    public String makeReservation(ReservationDTO dto) throws IOException {
        //ReservationDTO dto = new ReservationDTO(rev);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = objectMapper.writeValueAsString(dto);
        return given().log().all().body(json).contentType(ContentType.JSON).when().post(BASE_URI).asString();
    }

    /*
    * Maybe we need something here for the price. Like, if you are over 9 years old
    * it changes and all that stuff.
    * */
}
