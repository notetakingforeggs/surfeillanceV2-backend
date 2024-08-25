package com.surfeillance.surfeillanceV2_backend.util;


import com.surfeillance.surfeillanceV2_backend.model.Forecast;

public class OnshoreOffshore {

    public Boolean windIsOffshore(Forecast forecast) {

        Double offshoreMinimum = 100.0;

        Double difference = Math.abs(forecast.getSpot().getBeachFacing() - forecast.getWindDirection());
        if (difference >= 180) {
            difference = 360 - difference;
        }
        return difference >= offshoreMinimum;
    }

    public Boolean wavesAreOnshore(Forecast forecast) {
// Understand this bit more!
        Double degreesAwayFromDirectMax = 75D;
        Double difference = Math.abs(forecast.getWaveDirection() - forecast.getSpot().getBeachFacing());

        if(difference >= 180){
            difference = 360 - difference;
        }

        return difference < degreesAwayFromDirectMax;
    }

}
