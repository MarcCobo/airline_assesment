package com.dmg.flights.services;

import com.dmg.flights.models.Place;
import io.restassured.RestAssured;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.restassured.RestAssured.given;

@Service
public class PlaceService {
    public Place getPlace(long id){
        RestAssured.baseURI = "http://localhost:8080/db_api/place/";
        return given().when().get("/get/" + id)
                .then().assertThat().statusCode(200).extract().as(Place.class);
    }

    public List<Place> getAllPlaces(){
        RestAssured.baseURI = "http://localhost:8080/db_api/place/";
        return given().when().get("/get_all")
                .then().assertThat().statusCode(200).extract().body().jsonPath().getList(".", Place.class);
    }

    public List<String> getDestinations(String origin){
        RestAssured.baseURI = "http://localhost:8080/db_api/place/";
        return given().queryParam("origin", origin).when().get("/get_destinations")
                .then().assertThat().statusCode(200).extract().body().jsonPath().getList(".", String.class);
    }
}
