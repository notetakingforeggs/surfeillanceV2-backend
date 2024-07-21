package com.surfeillance.surfeillanceV2_backend.repository;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ForecastRepository extends JpaRepository<Forecast, Double> {

}
