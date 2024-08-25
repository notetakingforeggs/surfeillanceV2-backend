package com.surfeillance.surfeillanceV2_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Spot {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long spotId;

    @Column
    private String name;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private Double beachFacing;

    public Spot(String name, Double latitude, Double longitude, Double beachFacing) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.beachFacing = beachFacing;
    }
}
