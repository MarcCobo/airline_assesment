package com.dmg.flights;

import com.dmg.flights.models.Place;
import com.dmg.flights.services.PlaceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlaceTests {
    @Autowired
    PlaceService placeService;

    @Test
    public void getAllPlaces_WhenCalled_ReturnAllPlaces(){
        List<Place> list = placeService.getAllPlaces();
        Assertions.assertTrue(0 < list.size());
    }

    @Test
    public void getPlace_WhenCalled_ReturnSpecificPlace(){
        Place place = placeService.getPlace(1);
        Assertions.assertNotNull(place);
    }

    @Test
    public void getDestinations_WhenCalled_ReturnTheDestinationsAvailableFromThatOrigin(){
        List<Place> list = placeService.getDestinations("Bigaa");
        Assertions.assertTrue(0 < list.size());
    }
}
