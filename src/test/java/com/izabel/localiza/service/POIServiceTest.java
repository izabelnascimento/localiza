package com.izabel.localiza.service;


import com.izabel.localiza.domain.POI;
import com.izabel.localiza.repository.POIRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class POIServiceTest {

    @InjectMocks
    private POIServiceImpl poiService;
    @Mock
    private POIRepository poiRepository;

    @Test
    @DisplayName("Test a valid POI is create with success")
    void testCreateSuccesful() {
        POI poi = new POI();
        poi.setName("Name POI");
        poi.setRadius(100D);
        poi.setLatitude(-1D);
        poi.setLongitude(-2D);

        when(this.poiRepository.getPOIByLatitudeAndLongitudeAndRadius(-1D, -2D, 100D))
                .thenReturn(Optional.empty());
        when(this.poiRepository.save(poi))
                .thenReturn(poi);

        POI savedPoi = this.poiService.create(poi);

        verify(this.poiRepository, times(1)).save(poi);
        assertEquals(poi, savedPoi);
    }
}
