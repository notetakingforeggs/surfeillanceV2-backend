package com.surfeillance.surfeillanceV2_backend.service.api.waves;

public class WavesDAO {

    //https://marine-api.open-meteo.com/v1/marine?latitude=58.62353655543154&longitude=-3.650707683005074&hourly=wave_height&wind_speed_unit=mph&timezone=GMT&forecast_days=1&models=meteofrance_wave

    String BASE_URL_START = "https://marine-api.open-meteo.com/v1/marine?latitude=";
    String BASE_URL_MID = "&longitude=";
    String BASE_URL_END = "&hourly=wave_height&wind_speed_unit=mph&timezone=GMT&forecast_days=1&models=meteofrance_wave";
}
public static HourlyWaveData getWaveData(Double latitude, Double longitude){

}