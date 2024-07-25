package com.surfeillance.surfeillanceV2_backend.service.api.wind;

import com.surfeillance.surfeillanceV2_backend.service.api.wind.DTO.HourlyWindData;

public interface WindDAO {
    HourlyWindData getHourlyWindData(Double latitude, Double longitude);
}
