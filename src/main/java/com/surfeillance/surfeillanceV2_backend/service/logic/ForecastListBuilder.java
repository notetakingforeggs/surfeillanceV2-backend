// This all put into the service implementation


/*
package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO.HourlyWaveData;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAOimpl;

import java.util.ArrayList;
import java.util.List;

public class ForecastListBuilder {

    public List<Forecast> buildForecasts(HourlyWaveData waveData){

        List<Forecast> forecasts = new ArrayList<>();

        for (int i = 0; i < waveData.hourlyWaveInfo().time().length ; i++) {
            forecasts.get(i).setTime(waveData.hourlyWaveInfo().time()[i]);
            forecasts.get(i).setWaveHeight(waveData.hourlyWaveInfo().wave_height()[i]);
        }
        return forecasts;
    }

}
*/
