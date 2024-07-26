package com.surfeillance.surfeillanceV2_backend.service.api.wind;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surfeillance.surfeillanceV2_backend.service.api.wind.DTO.HourlyWindData;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class WindDAOimpl implements WindDAO {

//    https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=wind_speed_10m,wind_direction_10m,wind_gusts_10m&wind_speed_unit=mph&forecast_days=1

    String BASE_URL_START = "https://api.open-meteo.com/v1/forecast?latitude=";
    String BASE_URL_MID = "&longitude=";
    String BASE_URL_END = "&hourly=wind_speed_10m,wind_direction_10m,wind_gusts_10m&wind_speed_unit=mph&forecast_days=";
    String DAYS = "1";

    @Override
    public HourlyWindData getHourlyWindData(Double latitude, Double longitude) {

        String url = BASE_URL_START + latitude + BASE_URL_MID + longitude + BASE_URL_END + DAYS;

        try {
            HttpResponse<String> response;
            ObjectMapper mapper = new ObjectMapper();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            HourlyWindData hourlyWindData = mapper.readValue(response.body(), HourlyWindData.class);
            return hourlyWindData;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            System.out.println("issue with wind API call");
            e.printStackTrace();
            return null;
        }
    }
}

