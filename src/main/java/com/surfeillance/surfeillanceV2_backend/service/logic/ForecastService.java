package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.HourlyWaveData;

import java.util.List;

public interface ForecastService {
List<Forecast> getAllForecasts();
void saveAll(HourlyWaveData hourlyWaveData);
}
