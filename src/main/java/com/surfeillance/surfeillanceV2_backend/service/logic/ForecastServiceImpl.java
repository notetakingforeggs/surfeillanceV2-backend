package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.repository.ForecastRepository;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.HourlyWaveData;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAO;
import com.surfeillance.surfeillanceV2_backend.util.DateTimeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {
    @Autowired
    ForecastRepository forecastRepository;
    @Autowired
    WavesDAO dao;
    @Autowired
    DateTimeParser dateTimeParser;

    @Override
    public List<Forecast> getAllForecasts() {
        return (List<Forecast>) forecastRepository.findAll();
    }

    @Override
    public void saveAll(HourlyWaveData waveData) {
        List<Forecast> forecasts = new ArrayList<>();
        for (int i = 0; i < waveData.hourly().time().length; i++) {
            String date = dateTimeParser.getDate(waveData.hourly().time()[i]);
            String time = dateTimeParser.getTime(waveData.hourly().time()[i]);
            Double waveHeight = waveData.hourly().wave_height()[i];
            forecasts.add(new Forecast(date, time, waveHeight));
        }
        forecastRepository.saveAll(forecasts);
    }

    @Override
    public void deleteAll() {
        forecastRepository.deleteAll();
    }


}
