package com.izabel.localiza.service;

import com.izabel.localiza.domain.VehiclePOI;
import com.izabel.localiza.repository.VehiclePOIRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehiclePOIServiceTest {

    @InjectMocks
    private VehiclePOIServiceImpl vehiclePOIService;
    @Mock
    private VehiclePOIRepository vehiclePOIRepository;

    @Test
    @DisplayName("Test getAll without filters")
    void testGetAllWithoutFilters() {
        List<VehiclePOI> expectedList = new ArrayList<>();

        when(this.vehiclePOIRepository.findAll()).thenReturn(expectedList);

        List<VehiclePOI> resultList = this.vehiclePOIService.getAll(null, null, null);

        verify(vehiclePOIRepository, times(1)).findAll();
        assertEquals(expectedList, resultList);
    }

    @Test
    @DisplayName("Test getAll with plate filter")
    void testGetAllWithPlateFilter() {
        String plate = "ABC123";
        List<VehiclePOI> expectedList = new ArrayList<>();

        when(vehiclePOIRepository.findAllByPlate(plate)).thenReturn(expectedList);

        List<VehiclePOI> resultList = vehiclePOIService.getAll(plate, null, null);

        verify(vehiclePOIRepository, times(1)).findAllByPlate(plate);
        assertEquals(expectedList, resultList);
    }

    @Test
    @DisplayName("Test getAll with startDate filter")
    void testGetAllWithStartDateFilter() {
        Date startDate = new Date();
        List<VehiclePOI> expectedList = new ArrayList<>();

        when(vehiclePOIRepository.findAllByStartTimeAfter(startDate)).thenReturn(expectedList);

        List<VehiclePOI> resultList = vehiclePOIService.getAll(null, startDate, null);

        verify(vehiclePOIRepository, times(1)).findAllByStartTimeAfter(startDate);
        assertEquals(expectedList, resultList);
    }

    @Test
    @DisplayName("Test getAll with endDate filter")
    void testGetAllWithEndDateFilter() {
        Date endDate = new Date();
        List<VehiclePOI> expectedList = new ArrayList<>();

        when(vehiclePOIRepository.findAllByEndTimeBefore(endDate)).thenReturn(expectedList);

        List<VehiclePOI> resultList = vehiclePOIService.getAll(null, null, endDate);

        verify(vehiclePOIRepository, times(1)).findAllByEndTimeBefore(endDate);
        assertEquals(expectedList, resultList);
    }

    @Test
    @DisplayName("Test getAll with plate and starDate filters")
    void testGetAllWithPlateAndStartDatefilter() {
        String plate = "ABC123";
        Date startDate = new Date();
        List<VehiclePOI> expectedList = new ArrayList<>();

        when(vehiclePOIRepository.findAllByPlateAndStartTimeAfter(plate, startDate)).thenReturn(expectedList);

        List<VehiclePOI> resultList = vehiclePOIService.getAll(plate, startDate, null);

        verify(vehiclePOIRepository, times(1)).findAllByPlateAndStartTimeAfter(plate, startDate);
        assertEquals(expectedList, resultList);
    }

    @Test
    @DisplayName("Test getAll with startDate and endDate filter")
    void testGetAllWithStartDateAndEndDateFilter() {
        Date startDate = new Date();
        Date endDate = new Date();
        List<VehiclePOI> expectedList = new ArrayList<>();

        when(vehiclePOIRepository.findAllByStartTimeAfterAndEndTimeBefore(startDate, endDate)).thenReturn(expectedList);

        List<VehiclePOI> resultList = vehiclePOIService.getAll(null, startDate, endDate);

        verify(vehiclePOIRepository, times(1)).findAllByStartTimeAfterAndEndTimeBefore(startDate, endDate);
        assertEquals(expectedList, resultList);
    }

    @Test
    @DisplayName("Test getAll with plate and startDate filter")
    void testGetAllWithPlateAndEndDateFilter() {
        String plate = "ABC123";
        Date endDate = new Date();
        List<VehiclePOI> expectedList = new ArrayList<>();

        when(vehiclePOIRepository.findAllByPlateAndEndTimeBefore(plate, endDate)).thenReturn(expectedList);

        List<VehiclePOI> resultList = vehiclePOIService.getAll(plate, null, endDate);

        verify(vehiclePOIRepository, times(1)).findAllByPlateAndEndTimeBefore(plate, endDate);
        assertEquals(expectedList, resultList);
    }


}
