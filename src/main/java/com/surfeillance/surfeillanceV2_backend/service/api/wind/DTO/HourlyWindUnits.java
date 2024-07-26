package com.surfeillance.surfeillanceV2_backend.service.api.wind.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HourlyWindUnits() {
}
