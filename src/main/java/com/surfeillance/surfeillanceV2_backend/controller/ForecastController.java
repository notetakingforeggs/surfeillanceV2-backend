package com.surfeillance.surfeillanceV2_backend.controller;


import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.service.logic.ForecastService;
import com.surfeillance.surfeillanceV2_backend.service.logic.ForecastServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/forecast")
public class ForecastController {
    @Autowired
    ForecastService service;

    // get all forecasts? ever? would i ever get forecasts without specifying which?
    // potentially get all forecasts and have them as a looong list of forecast objects
    // then could pass this list around between views as json, taking the specific data i want?

    // Alternately, do calls to backend for a subset of the forecast data, in each view? idk what is better.
    // assumption would be that holding all the forecasts on in phone memory would be ram heavy
    // but that more calls to backend would be slowed by network setup, and potentially more of
    // an issue for surf forecasting where you might find yourself in places with no internet.
    // #local first

    // options are just passing this fckn massive list of objects around, or using the local sqlite db
    // going to try object list which seems like a bad idea but will find out.

    // But then how will this work? can i schedule periodic attempts at pulling the fresh master
    // forecast list on the frontend? maybe can do a conditional before each new view - is current
    // date time more than 6h (or whatever the refresh period will be from the timestamps on the
    // forecast data in use? if so then call the backend.
    // TODO put timestamp in forecasts


    @GetMapping
    public ResponseEntity<List<Forecast>> getAllForecasts(){
        System.out.println("controller getAllForecasts");

        List<Forecast> forecasts = service.getAllForecasts();

        return new ResponseEntity<>(forecasts, HttpStatus.OK);
    }



}
