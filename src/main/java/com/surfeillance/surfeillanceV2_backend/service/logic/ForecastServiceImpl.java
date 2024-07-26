package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.repository.ForecastRepository;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO.HourlyWaveData;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAO;
import com.surfeillance.surfeillanceV2_backend.service.api.wind.DTO.HourlyWindData;
import com.surfeillance.surfeillanceV2_backend.service.api.wind.WindDAO;
import com.surfeillance.surfeillanceV2_backend.util.DateTimeParser;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    WavesDAO wavesDAO;
    @Autowired
    WindDAO windDAO;

    @Override
    public List<Forecast> getAllForecasts() {
        return (List<Forecast>) forecastRepository.findAll();
    }

    @Override
    public Boolean saveAll(Double latitude, Double longitude) {


        HourlyWaveData waveData = wavesDAO.getHourlyWaveData(latitude,longitude);
        HourlyWindData windData = windDAO.getHourlyWindData(latitude, longitude);

        List<Forecast> forecasts = new ArrayList<>();
        for (int i = 0; i < waveData.HourlyWave().time().length; i++) {
            String date = dateTimeParser.getDate(waveData.HourlyWave().time()[i]);
            String time = dateTimeParser.getTime(waveData.HourlyWave().time()[i]);
            Double waveHeight = waveData.HourlyWave().wave_height()[i];
            Double waveDirection = waveData.HourlyWave().wave_direction()[i];
            Double wavePeriod = waveData.HourlyWave().wave_period()[i];

            Double windSpeed = windData.hourly().wind_speed_10m()[i];
            Double windDirection = windData.hourly().wind_direction_10m()[i];
            Double windGusts = windData.hourly().wind_gusts_10m()[i];

            forecasts.add(new Forecast(date, time, waveHeight, waveDirection, wavePeriod, windSpeed, windDirection, windGusts));
        }
        forecastRepository.saveAll(forecasts);
        return true;
    }

    @Override
    public Boolean deleteAll() {
        forecastRepository.deleteAll();
        return true;
    }


}
