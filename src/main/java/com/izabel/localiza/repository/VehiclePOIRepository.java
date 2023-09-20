package com.izabel.localiza.repository;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.domain.VehiclePOI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehiclePOIRepository extends JpaRepository<VehiclePOI, Long> {
    Optional<VehiclePOI> getVehiclePOIByPlateAndPoi(String plate, POI poi);
    List<VehiclePOI> findAllByPlate(String plate);
    List<VehiclePOI> findAllByStartTimeAfter(Date startTime);
    List<VehiclePOI> findAllByEndTimeBefore(Date endTime);
    List<VehiclePOI> findAllByPlateAndStartTimeAfter(String plate, Date startTime);
    List<VehiclePOI> findAllByPlateAndEndTimeBefore(String plate, Date endTime);
    List<VehiclePOI> findAllByStartTimeAfterAndEndTimeBefore(Date startTime, Date endTime);
    List<VehiclePOI> findAllByPlateAndStartTimeAfterAndEndTimeBefore(String plate, Date startTime, Date endTime);
}
