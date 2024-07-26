package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.model.Spot;

import java.util.List;

public interface ForecastService {

List<Forecast> getAllForecasts();

Boolean saveAllForecasts(Spot spot);

Boolean deleteAll();
}
