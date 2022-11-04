package com.dmg.databasegateway.services;

import com.dmg.databasegateway.models.Analytics;
import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.Place;
import com.dmg.databasegateway.repositories.AnalyticsJpaRepository;
import com.dmg.databasegateway.repositories.FlightJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightJpaRepository repository;
    @Autowired
    private PlaceService placeService;
    @Autowired
    private AnalyticsJpaRepository analyticsRepository;

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Flight getFlight(long id) {
        Optional<Flight> flight = repository.findById(id);
        return flight.get();
    }

    public List<Flight> getFlightsFilterByOrigin(String origin) {
        Place place = placeService.findPlaceByName(origin);
        updateCheckedFlights(place);
        return repository.findFlightByOrigin(place);
    }

    public List<Flight> getFlightsFilterByOriginAndDateBetween(String origin, LocalDate startDate, LocalDate endDate) {
        Place place = placeService.findPlaceByName(origin);
        updateCheckedFlights(place);
        return repository.findFlightByOriginAndDateBetween(place, startDate, endDate);
    }

    public List<Flight> getFlightsFilterByOriginAndDestinationAndDateBetween(String origin, String destination, LocalDate startDate, LocalDate endDate) {
        Place place = placeService.findPlaceByName(origin);
        updateCheckedFlights(place);
        Place place2 = placeService.findPlaceByName(destination);
        updateCheckedFlights(place2);
        return repository.findFlightByOriginAndDestinationAndDateBetween(place, place2, startDate, endDate);
    }

    public List<Flight> getFlightsFilterByOriginAndDate(String origin, LocalDate startDate) {
        Place place = placeService.findPlaceByName(origin);
        updateCheckedFlights(place);
        return repository.findFlightByOriginAndDate(place, startDate);
    }

    /*
     * COMO GESTIONAMOS ESTO CON LOS GET DE VUELOS:
     *   0.- Creo que antes de acceder hemos encontrado el Place - CIERTO
     *   1.- analytic = repository.FindByPlace(place); // Tambien con destination
     *   2.- analytic.checkedFlights++;
     *   3.- repository.save(analytic);
     * */

    private void updateCheckedFlights(Place place){
        Optional<Analytics> optionalAnalytics = analyticsRepository.findById(place.getId());
        if(optionalAnalytics.isPresent()){
            Analytics analytics = optionalAnalytics.get();
            analytics.setCheckedFlights(analytics.getCheckedFlights() +1);
            analyticsRepository.save(analytics);
        }
    }
}
