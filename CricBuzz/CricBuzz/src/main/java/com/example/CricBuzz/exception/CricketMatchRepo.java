package com.example.CricBuzz.exception;

import com.example.CricBuzz.model.CricketMatch;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketMatchRepo extends JpaRepository<CricketMatch, Integer> {
}
