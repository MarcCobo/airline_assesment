package com.dmg.databasegateway.repositories;

import com.dmg.databasegateway.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {
}
