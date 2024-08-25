package com.surfeillance.surfeillanceV2_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.surfeillance.surfeillanceV2_backend.util.RatingCalculator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@NoArgsConstructor
public class Forecast {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forecastId;

    @Column(name = "creation_time", updatable = false)
    @CreationTimestamp
    private String creationTime;

    @ManyToOne
    @JoinColumn(name = "spotId")
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

    @Column
    private Boolean isDecent;


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
        this.isDecent = null;
    }

    public void updateRating(){
        RatingCalculator ratingCalculator = new RatingCalculator();
        if(ratingCalculator.isDecent(this)){
            this.isDecent = true;
        }else{
            this.isDecent = false;
        }
    }

}
