package com.dmg.databasegateway.repositories;

import com.dmg.databasegateway.models.Flight;
import com.dmg.databasegateway.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightJpaRepository extends JpaRepository<Flight, Long> {
    public List<Flight> findFlightByOrigin(Place place);
    public List<Flight> findFlightByOriginAndDateBetween(Place place, LocalDate startDate, LocalDate endDate);
    public List<Flight> findFlightByOriginAndDate(Place place, LocalDate startDate);
}
