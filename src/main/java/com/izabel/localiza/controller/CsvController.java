package com.izabel.localiza.controller;

import com.izabel.localiza.service.CsvService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv")
@AllArgsConstructor
public class CsvController {

    private final CsvService csvService;

    @PostMapping("/read-pois")
    public ResponseEntity<Void> readPOICsv() throws Exception {
        this.csvService.readPoisCsv("pois.csv");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/read-positions")
    public ResponseEntity<Void> readPositionCsv() throws Exception {
        this.csvService.readPositionsCsv("positions.csv");
        return ResponseEntity.ok().build();
    }
}

