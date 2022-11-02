package com.dmg.flights;

import com.dmg.flights.models.Flight;
import com.dmg.flights.services.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class FlightTests {

    @Autowired
    FlightService service;

    @Test
    public void getFlightsWithDto_WhenCalled_ReturnFlightDto(){
        Assertions.assertNotNull(service.getFlight(1));
    }

    @Test
    public void getFlightsFilteredByOrigin_WhenCalled_ReturnFlightsDto(){
        List<Flight> flightList = service.getFlightFilterByOrigin("Bigaa");
        Assertions.assertTrue(0 < flightList.size());
    }

    @Test
    public void getFlightsFilteredByOriginAndDate_WhenCalled_ReturnFlightsDto(){
        List<Flight> flightList = service.getFlightFilterByOriginAndDate("Bigaa", "2022-11-02");
        Assertions.assertTrue(0 < flightList.size());
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
