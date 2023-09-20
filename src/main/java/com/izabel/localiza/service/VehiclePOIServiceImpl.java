package com.izabel.localiza.service;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.domain.VehiclePOI;
import com.izabel.localiza.repository.VehiclePOIRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehiclePOIServiceImpl implements VehiclePOIService{

    private final VehiclePOIRepository vehiclePOIRepository;

    public Optional<VehiclePOI> getVehiclePOIByPlateAndPoi(String plate, POI poi){
        return this.vehiclePOIRepository.getVehiclePOIByPlateAndPoi(plate, poi);
    }

    @Override
    public VehiclePOI create(VehiclePOI vehiclePOI) {
        return this.vehiclePOIRepository.save(vehiclePOI);
    }

    @Override
    public List<VehiclePOI> getAll(String plate, Date startDate, Date endDate) {
        if (plate == null && startDate == null && endDate == null){
            return this.vehiclePOIRepository.findAll();
        } else if (plate != null && startDate == null && endDate == null){
            return this.vehiclePOIRepository.findAllByPlate(plate);
        } else if (plate == null && startDate != null && endDate == null){
            return this.vehiclePOIRepository.findAllByStartTimeAfter(startDate);
        } else if (plate == null && startDate == null){
            return this.vehiclePOIRepository.findAllByEndTimeBefore(endDate);
        } else if (plate != null && startDate != null && endDate == null){
            return this.vehiclePOIRepository.findAllByPlateAndStartTimeAfter(plate, startDate);
        } else if (plate == null){
            return this.vehiclePOIRepository.findAllByStartTimeAfterAndEndTimeBefore(startDate, endDate);
        } else if (startDate == null){
            return this.vehiclePOIRepository.findAllByPlateAndEndTimeBefore(plate, endDate);
        }
        return this.vehiclePOIRepository.findAllByPlateAndStartTimeAfterAndEndTimeBefore(plate, startDate, endDate);
    }
}
