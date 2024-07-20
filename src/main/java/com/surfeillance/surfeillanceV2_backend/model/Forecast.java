package com.surfeillance.surfeillanceV2_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Forecast {
    // wave: height, period, direction
    //wind: speed direction(maybe gusts later)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String time;

    private Double waveHeight;

    private Double wavePeriod;

    private String waveDirection;

    private Double windSpeed;

    private String windDirection;




}
