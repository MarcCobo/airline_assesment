package com.dmg.reservations.services;

import com.dmg.reservations.models.Reservation;
import com.dmg.reservations.models.ReservationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Service
public class ReservationService {

    public static String BASE_URI = "http://localhost:8080/dbapi/reservation";

    public Response makeReservation(Reservation rev) {
        ReservationDTO dto = new ReservationDTO(rev);
        return given().log().all().body(dto).contentType(ContentType.JSON).when().post(BASE_URI + "/add");
    }

    /*
    * Maybe we need something here for the price. Like, if you are over 9 years old
    * it changes and all that stuff.
    * */
}
