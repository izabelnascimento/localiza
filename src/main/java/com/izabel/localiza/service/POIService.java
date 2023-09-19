package com.izabel.localiza.service;

import com.izabel.localiza.domain.POI;

import java.util.List;

public interface POIService {
    POI create(POI poi);
    List<POI> getAll();
}
