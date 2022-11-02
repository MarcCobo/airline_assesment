package com.dmg.flights;

import com.dmg.flights.services.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class FlightTests {

    @Autowired
    FlightService service;

    @Test
    public void getFlightsWithDto_WhenCalled_ReturnFlightDto(){
        Assertions.assertNotNull(service.getFlight(1));
    }

    @Test
    public void getFlights_NoFlightsWithDate_MakeCallWithNextDayAndReturnFlights(){
        /*
        Get the date for the flights and if that dat doesn't have any flights search the next day
         */
    }

    @Test
    public void getDestinationsFromFlight_WhenCalled_ReturnPlaces(){
        /*
        Get the destinations from the flights
         */
    }
}
