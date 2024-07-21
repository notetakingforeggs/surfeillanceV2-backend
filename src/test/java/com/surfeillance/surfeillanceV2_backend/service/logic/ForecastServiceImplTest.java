package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.repository.ForecastRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ForecastServiceImplTest {

    // mocking the repository
    @Mock
    ForecastRepository mockRepository;

    // injecting the mocked repo into the service
    @InjectMocks
    ForecastServiceImpl forecastService;

    @Test
    void getAllForecastsTest() {

        List<Forecast> dummyForecasts = new ArrayList<>(List.of(
                new Forecast("2020-01-01", "16:00", 1.4),
                new Forecast("2020-01-01", "17:00", 1.6),
                new Forecast("2020-01-01", "18:00", 1.8)
        ));


        //Arrange
        when(mockRepository.findAll()).thenReturn(dummyForecasts);

        //Act
        List<Forecast> forecasts = forecastService.getAllForecasts();

        //Assert
        verify(mockRepository, times(1)).findAll();

        assertEquals(forecasts, dummyForecasts);
    }

}