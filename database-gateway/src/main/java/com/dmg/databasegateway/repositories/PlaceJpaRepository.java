package com.dmg.databasegateway.repositories;

import com.dmg.databasegateway.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceJpaRepository extends JpaRepository<Place, Long> {
}
