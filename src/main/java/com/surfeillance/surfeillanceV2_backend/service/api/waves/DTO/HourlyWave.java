package com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HourlyWave(String[] time, Double[] wave_height, Double[] wave_direction, Double[] wave_period) {
}
