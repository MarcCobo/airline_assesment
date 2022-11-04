package com.dmg.databasegateway.services;

import com.dmg.databasegateway.models.Analytics;
import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.models.Reservation;
import com.dmg.databasegateway.repositories.AnalyticsJpaRepository;
import com.dmg.databasegateway.repositories.FlightJpaRepository;
import com.dmg.databasegateway.repositories.PlaceJpaRepository;
import com.dmg.databasegateway.repositories.ReservationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationJpaRepository repository;
    @Autowired
    private FlightJpaRepository flightRepository;
    @Autowired
    private PlaceJpaRepository placeRepository;
    @Autowired
    private AnalyticsJpaRepository analyticsRepository;

    public Reservation save(Reservation reservation){
        updateBookedFlights(reservation.getFlightId().getOrigin());
        updateBookedFlights(reservation.getFlightId().getDestination());
        return repository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Reservation addOneFixedReservation() {
        Place origin = placeRepository.save(new Place("Sevilla"));
        Place destination = placeRepository.save(new Place("Madrid"));
        Flight newFlight = flightRepository.save(new Flight("Ryanair", "AN237190", origin, destination, LocalDate.now(), 50, 2L, "2 WHOLE LAYOVERS", true, 56));

        Reservation newReservation = new Reservation(newFlight,"George","Kapsalakos","Greek","AA12345",25,true, 1, 10.0);
        return repository.save(newReservation);
    }

    public Reservation getReservation(long id) {
        Optional<Reservation> reservation = repository.findById(id);
        return reservation.get();
    }

    /*
     * COMO GESTIONAMOS ESTO CON LAS RESERVAS:
     *   1.- analytic = repository.FindByPlace(reservation.origin); // Tambien con destination
     *   2.- analytic.bookedFlights++;
     *   3.- repository.save(analytic);
     * */

    private void updateBookedFlights(Place place){
        Optional<Analytics> optionalAnalytics = analyticsRepository.findById(place.getId());
        if(optionalAnalytics.isPresent()){
            Analytics analytics = optionalAnalytics.get();
            analytics.setBookedFlights(analytics.getBookedFlights() +1);
            analyticsRepository.save(analytics);
        }
    }
}
