package com.izabel.localiza.controller;

import com.izabel.localiza.domain.POI;
import com.izabel.localiza.service.POIService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poi")
@AllArgsConstructor
public class POIController {

    private final POIService poiService;

    @PostMapping
    @ApiOperation("Add a new POI")
    public ResponseEntity<POI> addPOI(@RequestBody POI poi){
        return ResponseEntity.ok(this.poiService.create(poi));
    }
}
