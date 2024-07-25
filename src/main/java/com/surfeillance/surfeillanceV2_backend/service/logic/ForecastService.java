package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.HourlyWaveData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ForecastService {

List<Forecast> getAllForecasts();

Boolean saveAll(HourlyWaveData hourlyWaveData);

Boolean deleteAll();
}
