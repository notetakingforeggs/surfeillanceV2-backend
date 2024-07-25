package com.surfeillance.surfeillanceV2_backend.service.api.waves;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HourlyUnits (){
}

// ignore this and just use one set of units for now.