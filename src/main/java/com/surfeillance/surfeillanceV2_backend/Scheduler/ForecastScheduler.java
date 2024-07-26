package com.surfeillance.surfeillanceV2_backend.Scheduler;

import com.surfeillance.surfeillanceV2_backend.model.Spot;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO.HourlyWaveData;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAO;
import com.surfeillance.surfeillanceV2_backend.service.api.wind.DTO.HourlyWindData;
import com.surfeillance.surfeillanceV2_backend.service.api.wind.WindDAO;
import com.surfeillance.surfeillanceV2_backend.service.logic.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ForecastScheduler {

    @Autowired
    private ForecastService forecastService;

    @Autowired
    private WavesDAO wavesDAO;

    @Autowired
    private WindDAO windDAO;


    @Scheduled(fixedRate = 60000) // run every 5 mins for testing - use cron notation to run at 6 hour intervals in prod
    // @Scheduled(cron = "0 */6 * * *")
    public void updateForecastDate(/*List<Spot> spots*/) {

        Spot thurso = new Spot("Thurso East", 58.5927, -3.5259);
        Spot austi = new Spot("Austinmer", -34.3052, 150.9333);

        List<Spot> spots = List.of(thurso, austi);
        forecastService.deleteAll();
        for (Spot spot : spots) {
            forecastService.saveAll(spot.latitude(), spot.longitude());
        }

    }
}
