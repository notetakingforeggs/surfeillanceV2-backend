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
    private Long forecastId;

    @ManyToOne
    @JoinColumn(name = "spotId" )
    private Spot spot;
    
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

    @Column
    private Double windSpeed;

    @Column
    private Double windDirection;

    @Column
    private Double windGusts;

    public Forecast(Spot spot, String date, String time, Double waveHeight, Double waveDirection, Double wavePeriod, Double windSpeed, Double windDirection, Double windGusts) {
        this.spot = spot;
        this.date = date;
        this.time = time;
        this.waveHeight = waveHeight;
        this.waveDirection = waveDirection;
        this.wavePeriod = wavePeriod;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.windGusts = windGusts;
    }

}
