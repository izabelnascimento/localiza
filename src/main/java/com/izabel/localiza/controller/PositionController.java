package com.izabel.localiza.controller;

import com.izabel.localiza.domain.Position;
import com.izabel.localiza.service.PositionService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/position")
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    @ApiOperation("Add a new position")
    public ResponseEntity<Position> addPosition(@RequestBody Position position){
        return ResponseEntity.ok(this.positionService.create(position));
    }
}
