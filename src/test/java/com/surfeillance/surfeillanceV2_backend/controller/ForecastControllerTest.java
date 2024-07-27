package com.surfeillance.surfeillanceV2_backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.model.Spot;
import com.surfeillance.surfeillanceV2_backend.service.logic.ForecastService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class ForecastControllerTest {

    @Mock
    ForecastService forecastServiceMock;

    @InjectMocks
    ForecastController forecastController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mockMvcController = MockMvcBuilders.standaloneSetup(forecastController).build();
        mapper = new ObjectMapper();
    }

    @Test
    void getAllForecasts() throws Exception {


        List<Forecast> forecasts = List.of(
                new Forecast(new Spot(), "date", "time", 1.5, 120.0, 11.1, 15.1, 30.2, 20.0),
                new Forecast(new Spot(), "date2", "time2", 1.7, 120.0, 11.1, 15.1, 30.2, 20.0));

        when(forecastServiceMock.getAllForecasts()).thenReturn(forecasts);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/forecast"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].time").value("time"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].waveHeight").value(1.7));

        verify(forecastServiceMock, times(1)).getAllForecasts();
    }
}