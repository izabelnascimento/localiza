package com.izabel.localiza.service;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.repository.POIRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class POIServiceImpl implements POIService {

    private final POIRepository poiRepository;

    @Override
    public POI create(POI poi) {
        Optional<POI> optionalPOI = this.poiRepository.getPOIByLatitudeAndLongitudeAndRadius(
                poi.getLatitude(),
                poi.getLongitude(),
                poi.getRadius());

        optionalPOI.ifPresent(value -> poi.setId(value.getId()));

        return this.poiRepository.save(poi);
    }

    @Override
    public List<POI> getAll() {
        return this.poiRepository.findAll();
    }
}
