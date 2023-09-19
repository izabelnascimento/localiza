package com.izabel.localiza.service;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.repository.POIRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class POIServiceImpl implements POIService {

    private final POIRepository poiRepository;

    @Override
    public POI create(POI poi) {
        return this.poiRepository.save(poi);
    }

    @Override
    public List<POI> getAll() {
        return this.poiRepository.findAll();
    }
}
