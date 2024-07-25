package com.surfeillance.surfeillanceV2_backend.service.api.waves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record hourly(String[] time, Double[] wave_height) {
}