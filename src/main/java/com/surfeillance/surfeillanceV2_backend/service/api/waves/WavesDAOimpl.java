package com.surfeillance.surfeillanceV2_backend.service.api.waves;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
public class WavesDAOimpl implements WavesDAO {
    //https://marine-api.open-meteo.com/v1/marine?latitude=58.62353655543154&longitude=-3.650707683005074&hourly=wave_height&wind_speed_unit=mph&timezone=GMT&forecast_days=1&models=meteofrance_wave

    @Autowired
    private RestTemplate restTemplate;

    String BASE_URL_START = "https://marine-api.open-meteo.com/v1/marine?latitude=";
    String BASE_URL_MID = "&longitude=";
    String BASE_URL_END = "&hourly=wave_height&wind_speed_unit=mph&timezone=GMT&forecast_days=1&models=meteofrance_wave";


    @Override
    public HourlyWaveData getHourlyWaveData(Double longitude, Double latitude) {

        String url = BASE_URL_START + longitude + BASE_URL_MID + latitude + BASE_URL_END;
        try {
            return restTemplate.getForObject(url, HourlyWaveData.class);
        } catch (Exception e) {
            System.out.println("Error in RestTemplate accessing Waves API");
            e.printStackTrace();
        }
        System.out.println("rest template failed to return hourly wave data in DAO");
        return null;
    }
}


//
//        try {
//            HttpResponse<String> response;
//            ObjectMapper mapper = new ObjectMapper();
//
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(new URI(BASE_URL_START + latitude + BASE_URL_MID + longitude + BASE_URL_END))
//                    .GET()
//                    .build();
//
//            response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            HourlyWaveData hourlyWaveData = mapper.readValue(response.body(), HourlyWaveData.class);
//            return hourlyWaveData;
//        } catch (URISyntaxException | InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//
//        }
