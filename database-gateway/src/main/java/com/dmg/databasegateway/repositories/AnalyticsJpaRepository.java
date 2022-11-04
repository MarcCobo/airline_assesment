package com.dmg.databasegateway.repositories;

import com.dmg.databasegateway.models.Analytics;
import com.dmg.databasegateway.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsJpaRepository extends JpaRepository<Analytics, Long> {
//    public Analytics findByPlace(Place place);
}
