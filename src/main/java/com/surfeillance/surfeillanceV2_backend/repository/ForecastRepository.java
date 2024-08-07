package com.surfeillance.surfeillanceV2_backend.repository;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

}
