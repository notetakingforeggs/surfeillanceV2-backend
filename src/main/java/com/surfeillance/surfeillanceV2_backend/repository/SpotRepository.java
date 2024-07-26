package com.surfeillance.surfeillanceV2_backend.repository;

import com.surfeillance.surfeillanceV2_backend.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {
}
