package com.dmg.flights.services;

import com.dmg.flights.models.Flight;
import io.restassured.RestAssured;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

@Service
public class FlightService {

    public Flight getFlight(long id){
        RestAssured.baseURI = "http://localhost:8080/db_api/flight/";
        return given().when().get("/get_dto/"+id)
                .then().assertThat().statusCode(200).extract().as(Flight.class);
    }

    public List<Flight> getFlightFilterByOrigin(String origin){
        RestAssured.baseURI = "http://localhost:8080/db_api/flight/";
        return given().queryParam("origin", origin).when().get("/get_dto/origin")
                .then().assertThat().statusCode(200).extract().body().jsonPath().getList(".", Flight.class);
    }

    public List<Flight> getFlightFilterByOriginAndDate(String origin, String date) {
        RestAssured.baseURI = "http://localhost:8080/db_api/flight/";
        List<Flight> list = given().log().all().queryParam("origin", origin).queryParam("date", date).when().get("/get_dto/origin_and_date")
                .then().log().all().assertThat().statusCode(200).extract().body().jsonPath().getList(".", Flight.class);
        System.out.println(list);
        return list;
    }

    public List<Flight> getFlightFilterByOriginAndDateBetween(String origin, String startDate, String endDate) {
        RestAssured.baseURI = "http://localhost:8080/db_api/flight/";
        List<Flight> list = given().log().all().queryParam("origin", origin).queryParam("startDate", startDate)
                .queryParam("endDate",endDate).when().get("/get_dto/origin_and_date_between")
                .then().log().all().assertThat().statusCode(200).extract().body().jsonPath().getList(".", Flight.class);
        System.out.println(list);
        return list;
    }
}
