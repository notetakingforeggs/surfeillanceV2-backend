package com.surfeillance.surfeillanceV2_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Forecast {
    // wave: height, period, direction
    //wind: speed direction(maybe gusts later)

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private Double waveHeight;


    public Forecast(String date, String time, Double waveHeight) {
        this.date = date;
        this.time = time;
        this.waveHeight = waveHeight;
    }

//    private Double wavePeriod;

//    private String waveDirection;

//    private Double windSpeed;

//    private String windDirection;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getWaveHeight() {
        return waveHeight;
    }

    public void setWaveHeight(Double waveHeight) {
        this.waveHeight = waveHeight;
    }
}
