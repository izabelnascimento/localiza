package com.izabel.localiza.controller;

import com.izabel.localiza.service.VehiclePOIService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/vehicle-poi")
@AllArgsConstructor
public class VehiclePOIController {

    private final VehiclePOIService vehiclePOIService;

    @GetMapping
    @ApiOperation("Get all vehicles in POIs")
    public ResponseEntity<?> getAll(
            @RequestParam(required = false) String plate,
            @RequestParam(required = false) String startDateStr,
            @RequestParam(required = false) String endDateStr) {

        Date startDate = null;
        Date endDate = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            if (startDateStr != null) {
                startDate = dateFormat.parse(startDateStr);
            }

            if (endDateStr != null) {
                endDate = dateFormat.parse(endDateStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid date format [yyyy-MM-ddTHH:mm:ss]");
        }
        return ResponseEntity.ok(this.vehiclePOIService.getAll(plate, startDate, endDate));
    }

}
