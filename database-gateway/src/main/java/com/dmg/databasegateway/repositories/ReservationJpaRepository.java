package com.dmg.databasegateway.repositories;

import com.dmg.databasegateway.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {
}
