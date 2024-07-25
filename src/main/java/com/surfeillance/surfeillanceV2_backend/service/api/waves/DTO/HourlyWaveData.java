package com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HourlyWaveData(Double latitude, Double longitude, @JsonProperty("hourly_units") HourlyWaveUnits hourlyWaveUnits, @JsonProperty("hourly") HourlyWave HourlyWave) {
}
