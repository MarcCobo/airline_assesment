package com.dmg.flights.services;

import com.dmg.flights.models.Place;
import io.restassured.RestAssured;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.restassured.RestAssured.given;

@Service
public class PlaceService {

    private static String BASE_URL = "http://localhost:8080/db_api/place/";

    public Place getPlace(long id){
//        RestAssured.baseURI = "http://localhost:8080/db_api/place/";
        return given().when().get(BASE_URL + "get/" + id)
                .then().assertThat().statusCode(200).extract().as(Place.class);
    }

    public List<Place> getAllPlaces(){
        RestAssured.baseURI = "http://localhost:8080/db_api/place";
        return given().when().get("/get_all")
                .then().assertThat().statusCode(200).extract().body().jsonPath().getList(".", Place.class);
    }


    public List<Place> getDestinations(String origin){
       // RestAssured.baseURI = "http://localhost:8080/db_api/place";
        return given().log().all().queryParam("origin", origin).when().get(BASE_URL + "get_destinations")
                .then().log().all().assertThat().statusCode(200).extract().body().jsonPath().getList(".", Place.class);
    }
}
