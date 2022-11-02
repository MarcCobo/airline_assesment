package com.dmg.flights.services;

import com.dmg.flights.models.Flight;
import io.restassured.RestAssured;
import org.springframework.stereotype.Service;
import static io.restassured.RestAssured.*;

@Service
public class FlightService {

    public Flight getFlight(long id){
        RestAssured.baseURI = "http://localhost:8080/dbapi/flight/";
        Flight flight =  given().when().get("/getdto/"+id).then().assertThat().statusCode(200).extract().as(Flight.class);
        System.out.println(flight);
        return new Flight();
    }
}
