package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.repository.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ForecastServiceImpl implements ForecastService{
    @Autowired
    ForecastRepository forecastRepository;

    @Override
    public List<Forecast> getAllForecasts() {
        return (List<Forecast>)forecastRepository.findAll();
    }

    @Override
    public void saveAll(List<Forecast> forecasts) {
        forecastRepository.saveAll(forecasts);
    }
}
