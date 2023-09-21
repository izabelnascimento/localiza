package com.izabel.localiza.service;

import com.izabel.localiza.domain.Position;
import com.izabel.localiza.repository.PositionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PositionServiceTest {

    @InjectMocks
    private PositionServiceImpl positionService;

    @Mock
    private PositionRepository positionRepository;

    @Mock
    private POIService poiService;

    @Test
    @DisplayName("Test a valid Position is create with succes")
    void testCreateSuccesful() {
        Position position = new Position();
        position.setPlate("ABC123");
        position.setPositionDate(new Date());
        position.setSpeed(100);
        position.setLatitude(-1D);
        position.setLongitude(-2D);

        when(this.positionRepository.getPositionByPlateAndPositionDate("ABC123", position.getPositionDate()))
                .thenReturn(Optional.empty());
        when(this.positionRepository.save(position))
                .thenReturn(position);
        when(this.poiService.getAll())
                .thenReturn(Collections.emptyList());

        Position savedPosition = this.positionService.create(position);

        verify(this.positionRepository, times(1)).save(position);
        assertEquals(position, savedPosition);
    }
}
