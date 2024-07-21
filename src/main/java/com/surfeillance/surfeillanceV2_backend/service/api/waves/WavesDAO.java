package com.surfeillance.surfeillanceV2_backend.service.api.waves;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WavesDAO {

    //https://marine-api.open-meteo.com/v1/marine?latitude=58.62353655543154&longitude=-3.650707683005074&hourly=wave_height&wind_speed_unit=mph&timezone=GMT&forecast_days=1&models=meteofrance_wave

    String BASE_URL_START = "https://marine-api.open-meteo.com/v1/marine?latitude=";
    String BASE_URL_MID = "&longitude=";
    String BASE_URL_END = "&hourly=wave_height&wind_speed_unit=mph&timezone=GMT&forecast_days=1&models=meteofrance_wave";


    public HourlyWaveData getWaveData(Double latitude, Double longitude) {
        try {
            HttpResponse<String> response;
            ObjectMapper mapper = new ObjectMapper();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL_START + latitude + BASE_URL_MID + longitude + BASE_URL_END))
                    .GET()
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            HourlyWaveData hourlyWaveData = mapper.readValue(response.body(), HourlyWaveData.class);
            return hourlyWaveData;
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);

        }
    }
}