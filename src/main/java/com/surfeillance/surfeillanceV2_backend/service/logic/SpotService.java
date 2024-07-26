package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Spot;

import java.util.List;

public interface SpotService {
    Boolean saveAll(List<Spot> spots);
    Boolean deleteAll();
}
