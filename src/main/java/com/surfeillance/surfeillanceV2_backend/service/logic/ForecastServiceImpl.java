package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.repository.ForecastRepository;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.HourlyWaveData;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ForecastServiceImpl implements ForecastService{
    @Autowired
    ForecastRepository forecastRepository;
    @Autowired
    WavesDAO dao;

    @Override
    public List<Forecast> getAllForecasts() {
        return (List<Forecast>)forecastRepository.findAll();
    }

    @Override
    public void saveAll(HourlyWaveData waveData) {



        List<Forecast> forecasts = new ArrayList<>();

        for (int i = 0; i < waveData.hourlyWaveInfo().time().length ; i++) {
            forecasts.get(i).setTime(waveData.hourlyWaveInfo().time()[i]);
            forecasts.get(i).setWaveHeight(waveData.hourlyWaveInfo().wave_height()[i]);
        }
        forecastRepository.saveAll(forecasts);
    }


    
}
