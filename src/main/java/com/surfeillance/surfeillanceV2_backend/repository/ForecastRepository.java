package com.surfeillance.surfeillanceV2_backend.repository;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import org.springframework.data.repository.CrudRepository;

public interface ForecastRepository extends CrudRepository<Forecast, Double> {

}
