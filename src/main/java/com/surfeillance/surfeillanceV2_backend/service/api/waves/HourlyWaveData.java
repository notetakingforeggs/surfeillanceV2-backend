package com.surfeillance.surfeillanceV2_backend.service.api.waves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record HourlyWaveData(Double latitude, Double longitude, HourlyUnits hourlyUnits, HourlyWaveInfo hourlyWaveInfo ) {
}
