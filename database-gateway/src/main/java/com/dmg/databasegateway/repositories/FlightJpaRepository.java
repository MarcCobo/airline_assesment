package com.dmg.databasegateway.repositories;

import com.dmg.databasegateway.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightJpaRepository extends JpaRepository<Flight, Long> {

}
