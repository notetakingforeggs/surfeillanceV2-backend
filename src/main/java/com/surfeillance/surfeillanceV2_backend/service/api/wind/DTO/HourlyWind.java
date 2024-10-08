package com.surfeillance.surfeillanceV2_backend.service.api.wind.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HourlyWind(String[] time, Double[] wind_speed_10m, Double[] wind_direction_10m, Double[] wind_gusts_10m) {
}
