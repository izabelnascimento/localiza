package com.izabel.localiza.util;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.domain.Position;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    private static final double EARTH_RADIUS = 6371;
    public Boolean isInsidePOI(Position position, POI poi){
        double distance = calculateDistance(poi.getLatitude(), poi.getLongitude(), position.getLatitude(), position.getLongitude());
        return distance <= poi.getRadius();
    }

    private double calculateDistance(Double poiLatitude, Double poiLongitude, Double positionLatitude, Double positionLongitude) {
        poiLatitude = Math.toRadians(poiLatitude);
        poiLongitude = Math.toRadians(poiLongitude);
        positionLatitude = Math.toRadians(positionLatitude);
        positionLongitude = Math.toRadians(positionLongitude);

        double dLat = positionLatitude - poiLatitude;
        double dLon = positionLongitude - poiLongitude;

        // Fórmula de Haversine
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(poiLatitude) * Math.cos(positionLatitude) *
                        Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}
