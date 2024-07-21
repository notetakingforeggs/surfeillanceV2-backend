package com.surfeillance.surfeillanceV2_backend.service.api.waves;

public interface WavesDAO {
    HourlyWaveData getHourlyWaveData(Double longitude, Double latitude);
}
