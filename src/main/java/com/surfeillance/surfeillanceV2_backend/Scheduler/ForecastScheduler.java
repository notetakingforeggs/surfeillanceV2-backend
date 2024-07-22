package com.surfeillance.surfeillanceV2_backend.Scheduler;

import com.surfeillance.surfeillanceV2_backend.model.Spot;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAO;
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


    @Scheduled(fixedRate = 300000 ) // run every 5 mins for testing - use cron notation to run at 6 hour intervals in prod
    // @Scheduled(cron = "0 */6 * * *")

    public void updateForecastDate(List<Spot> spots){

        for(Spot spot : spots){
            // for each spot, get the list of wave data and save it to the database. Will this work? is it saving the hours as well? I think so in the service layer...

            forecastService.saveAll(wavesDAO.getHourlyWaveData(spot.longitude(), spot.latitude()));
        }

    }
}
