package com.surfeillance.surfeillanceV2_backend.service.logic;

import com.surfeillance.surfeillanceV2_backend.model.Spot;
import com.surfeillance.surfeillanceV2_backend.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {
    @Autowired
    SpotRepository spotRepository;

    @Override
    public List<Spot> getAllSpots() {
        return spotRepository.findAll();
    }

    @Override
    public Boolean saveAll(List<Spot> spots) {
        spotRepository.saveAll(spots);
        return true;
    }

    @Override
    public Boolean deleteAll() {
        spotRepository.deleteAll();
        return true;
    }

}
