package com.example.CricBuzz.repository;

import com.example.CricBuzz.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
