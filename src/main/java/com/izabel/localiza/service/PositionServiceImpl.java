package com.izabel.localiza.service;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.domain.Position;
import com.izabel.localiza.domain.VehiclePOI;
import com.izabel.localiza.repository.PositionRepository;
import com.izabel.localiza.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final POIService poiService;
    private final Utils utils;
    private final VehiclePOIService vehiclePOIService;

    @Override
    public Position create(Position position) {
        Optional<Position> optionalPosition = this.positionRepository.getPositionByPlateAndPositionDate(
                position.getPlate(),
                position.getPositionDate());

        optionalPosition.ifPresent(value -> position.setId(value.getId()));

        checkPOI(position);
        return this.positionRepository.save(position);
    }

    private void checkPOI(Position position){
        List<POI> pois = this.poiService.getAll();
        for (POI poi: pois) {
            if (this.utils.isInsidePOI(position, poi)){
                Optional<VehiclePOI> optionalVehiclePOI =
                        this.vehiclePOIService.getVehiclePOIByPlateAndPoi(position.getPlate(), poi);
                if (optionalVehiclePOI.isPresent()){
                    VehiclePOI vehiclePOI = optionalVehiclePOI.get();

                    long timePosition = position.getPositionDate().getTime();
                    long startTime = vehiclePOI.getStartTime().getTime();
                    long endTime = vehiclePOI.getEndTime().getTime();

                    if (timePosition <= startTime){
                        vehiclePOI.setStartTime(position.getPositionDate());
                    } else if (timePosition >= endTime) {
                        vehiclePOI.setEndTime(position.getPositionDate());
                    }
                } else {
                    VehiclePOI vehiclePOI = new VehiclePOI();
                    vehiclePOI.setPlate(position.getPlate());
                    vehiclePOI.setStartTime(position.getPositionDate());
                    vehiclePOI.setEndTime(position.getPositionDate());
                    vehiclePOI.setPoi(poi);

                    this.vehiclePOIService.create(vehiclePOI);
                }
            }
        }
    }
}
