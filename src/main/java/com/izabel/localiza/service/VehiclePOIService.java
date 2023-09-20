package com.izabel.localiza.service;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.domain.VehiclePOI;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VehiclePOIService {
    Optional<VehiclePOI> getVehiclePOIByPlateAndPoi(String plate, POI poi);
    VehiclePOI create(VehiclePOI vehiclePOI);
    List<VehiclePOI> getAll(String plate, Date startDate, Date endDate);
}
