package com.izabel.localiza.repository;

import com.izabel.localiza.domain.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface POIRepository extends JpaRepository<POI, Long> {
    Optional<POI> getPOIByLatitudeAndLongitudeAndRadius(Double latitude, Double longitude, Double radius);
}
