package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.StatsConvertor;
import com.example.CricBuzz.dto.request.StatsRequest;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.Stats;
import com.example.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsService {

    @Autowired
    PlayerRepository playerRepository;

    public String addStatsForPlayer(StatsRequest statsRequest,
                                    int playerId) {

        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if(playerOptional.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player Id");
        }

        Player player = playerOptional.get();
        Stats stats = StatsConvertor.statsRequestToStats(statsRequest);
        stats.setPlayer(player);

        player.setStats(stats);

        Player savedPlayer = playerRepository.save(player); // save both player + stats
        return "Stats added for player"+savedPlayer.getName();
    }
}
