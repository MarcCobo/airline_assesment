package com.dmg.flights;

import com.dmg.flights.services.PlaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlaceTests {
    @Autowired
    PlaceService placeService;

    @Test
    public void getAllPlaces_WhenCalled_ReturnAllPlaces(){
        /*
        Call the get all method in return all the places in the database
         */
    }

    @Test
    public void getPlace_WhenCalled_ReturnSpecificPlace(){
        /*
        Call the method with an id and return that place
         */
    }

    @Test
    public void getDestinations_WhenCalled_ReturnTheDestinationsAvailableFromThatOrigin(){
        /*
        Call the method you pass the origin place and gets all the possible destination places
         */
    }
}
