package com.dmg.reservations.services;

import com.dmg.reservations.models.ReservationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

@Service
public class ReservationService {

    public String BASE_URI = "http://localhost:8080/db_api/reservation/add";

    public ResponseEntity<ReservationDTO> makeReservation(ReservationDTO dto) throws IOException {
        if (checkInput(dto)) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            String json = objectMapper.writeValueAsString(dto);
            given().log().all().body(json).contentType(ContentType.JSON).when().post(BASE_URI).asString();
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    private boolean checkInput(ReservationDTO dto) {
        if (dto.getFlightId() < 0 || dto.getName().isEmpty()
                || dto.getSurname().isEmpty() || dto.getNationality().isEmpty()
                || dto.getDni().isEmpty() || dto.getAge() <= 0) {
            return false;
        }
        return true;
    }

    public double getVariablePrice(int[] ages, boolean bags, double price) {
        double cumulativeExtra = 0;
        for (int age : ages) {
            if (age >= 9) cumulativeExtra += 0.2;
            if (2 <= age && age < 9) cumulativeExtra += 0.1;
        }
        if (bags) cumulativeExtra += 0.3;
        return price * ages.length + (price * cumulativeExtra);
    }
}
