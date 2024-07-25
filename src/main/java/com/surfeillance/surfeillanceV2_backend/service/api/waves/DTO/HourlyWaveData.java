package com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HourlyWaveData(Double latitude, Double longitude, HourlyUnits hourlyUnits, hourly hourly) {
}
