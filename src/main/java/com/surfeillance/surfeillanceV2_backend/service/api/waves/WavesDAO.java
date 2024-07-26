package com.surfeillance.surfeillanceV2_backend.service.api.waves;

import com.surfeillance.surfeillanceV2_backend.service.api.waves.DTO.HourlyWaveData;

public interface WavesDAO {
    HourlyWaveData getHourlyWaveData(Double latitude, Double longitude);
}
