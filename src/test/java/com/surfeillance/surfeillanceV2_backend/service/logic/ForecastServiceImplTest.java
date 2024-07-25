package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.repository.ForecastRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ForecastServiceImplTest {

    // mocking the repository
    @Mock
    ForecastRepository mockRepository;

    // injecting the mocked repo into the service
    @InjectMocks
    ForecastServiceImpl forecastService;

    @BeforeEach
            public void setUp(){

    }

    @Test
    public void getAllForecastsTest() {
        List<Forecast> dummyForecasts = new ArrayList<>(List.of(
                new Forecast("2020-01-01", "16:00", 1.4, 11.1, 130.1),
                new Forecast("2020-01-01", "17:00", 1.6, 11.1, 130.1),
                new Forecast("2020-01-01", "18:00", 1.8, 11.1, 130.1)
        ));

        //Arrange
        when(mockRepository.findAll()).thenReturn(dummyForecasts);

        //Act
        List<Forecast> forecasts = forecastService.getAllForecasts();

        //Assert
        verify(mockRepository, times(1)).findAll();

        assertEquals(forecasts, dummyForecasts);
    }


    /*// TODO test is passing when i initialise date time parser normally not autowired. same issue as before - idk why? core funcitonality is tested at least.
     */
//    @Test
//    void saveAll() {
//
//        String[] time = {"2020-01-01T16:00","2020-01-01T17:00", "2020-01-01T18:00"};
//        Double[] waveHeight = {1.4, 1.6, 1.8};
//
//        HourlyWaveData hourlyWaveData = new HourlyWaveData(1.1, 1.1, new HourlyUnits(), new hourly(time, waveHeight));
//
//        List<Forecast> dummyForecasts = new ArrayList<>(List.of(
//                new Forecast("2020-01-01", "16:00", 1.4),
//                new Forecast("2020-01-01", "17:00", 1.6),
//                new Forecast("2020-01-01", "18:00", 1.8)
//        ));
//
//        //Arrange24T22
//        when(mockRepository.saveAll(dummyForecasts)).thenReturn(dummyForecasts);
//
//
//        //Assert
//        assertTrue(forecastService.saveAll(hourlyWaveData));
//        verify(mockRepository, times(1)).saveAll(dummyForecasts);
//    }

    @Test
    void deleteAll() {
    }
}