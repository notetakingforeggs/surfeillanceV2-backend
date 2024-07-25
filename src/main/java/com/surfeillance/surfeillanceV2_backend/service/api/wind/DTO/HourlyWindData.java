package com.surfeillance.surfeillanceV2_backend.service.api.wind.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HourlyWindData(String latitude, String longitude, @JsonProperty("hourly_units") HourlyWindUnits units, @JsonProperty("hourly") HourlyWind hourly) { }