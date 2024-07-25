package com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HourlyWaveUnits(){
}

// ignore this and just use one set of units for now.