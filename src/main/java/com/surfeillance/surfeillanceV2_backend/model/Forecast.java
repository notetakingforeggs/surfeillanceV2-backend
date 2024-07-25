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

    @Column
    private Double waveDirection;

    @Column
    private Double wavePeriod;

    public Forecast(String date, String time, Double waveHeight, Double wavePeriod, Double waveDirection) {
        this.date = date;
        this.time = time;
        this.waveHeight = waveHeight;
        this.wavePeriod = wavePeriod;
        this.waveDirection = waveDirection;
    }

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

    public Double getWavePeriod() {
        return wavePeriod;
    }

    public void setWavePeriod(Double wavePeriod) {
        this.wavePeriod = wavePeriod;
    }

    public Double getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(Double waveDirection) {
        this.waveDirection = waveDirection;
    }
}
