package com.dmg.databasegateway.repositories;

import com.dmg.databasegateway.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceJpaRepository extends JpaRepository<Place, Long> {
}
