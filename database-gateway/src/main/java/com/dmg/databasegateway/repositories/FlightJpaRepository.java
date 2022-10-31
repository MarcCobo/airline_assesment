package com.dmg.databasegateway.repositories;

import com.dmg.databasegateway.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightJpaRepository extends JpaRepository<Flight, Long> {

}
