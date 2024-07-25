package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO.HourlyWaveData;

import java.util.List;

public interface ForecastService {

List<Forecast> getAllForecasts();

Boolean saveAll(HourlyWaveData hourlyWaveData);

Boolean deleteAll();
}
