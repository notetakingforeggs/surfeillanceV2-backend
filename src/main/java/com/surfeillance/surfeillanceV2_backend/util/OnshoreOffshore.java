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

/*

Constants: Consider defining the offshoreMinimum and degreesAwayFromDirectMax as constants with descriptive names in the OnshoreOffshore class.

private static final Double OFFSHORE_MINIMUM = 100.0;
private static final Double DEGREES_AWAY_FROM_DIRECT_MAX = 75.0;

More comments to explain for future selves

Method Simplification: The logic for adjusting the difference to be within 0 to 180 degrees is repeated in both methods. Consider extracting this logic into a helper method to avoid duplication.

private Double normalizeDifference(Double difference) {
    if (difference >= 180) {
        return 360 - difference;
    }
    return difference;
}

Then, use this method in both windIsOffshore and wavesAreOnshore methods.*/