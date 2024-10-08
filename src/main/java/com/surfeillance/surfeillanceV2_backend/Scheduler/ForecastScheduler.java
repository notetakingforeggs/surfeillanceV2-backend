package com.surfeillance.surfeillanceV2_backend.Scheduler;

import com.surfeillance.surfeillanceV2_backend.model.Spot;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAO;
import com.surfeillance.surfeillanceV2_backend.service.api.wind.WindDAO;
import com.surfeillance.surfeillanceV2_backend.service.logic.ForecastService;
import com.surfeillance.surfeillanceV2_backend.service.logic.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ForecastScheduler {

    @Autowired
    private ForecastService forecastService;

    @Autowired
    SpotService spotService;

    @Autowired
    private WavesDAO wavesDAO;

    @Autowired
    private WindDAO windDAO;


    @Scheduled(fixedRate = 600000) // run every 5 mins for testing - use cron notation to run at 6 hour intervals in prod
    // @Scheduled(cron = "0 */6 * * *")
    public void updateForecastDate(/*List<Spot> spots*/) {

        List<Spot> spots = spotService.getAllSpots();
        forecastService.deleteAll();
        for (Spot spot : spots) {
            forecastService.saveAllForecasts(spot);
        }

    }
}
