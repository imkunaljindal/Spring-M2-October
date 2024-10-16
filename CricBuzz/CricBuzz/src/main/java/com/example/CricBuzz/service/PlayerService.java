package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.PlayerConvertor;
import com.example.CricBuzz.dto.request.PlayerRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Enum.Gender;
import com.example.CricBuzz.model.Enum.Speciality;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        Player player = PlayerConvertor.playerRequestToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);
        return PlayerConvertor.playerToPlayerResponse(savedPlayer);
    }


    public PlayerResponse getPlayer(int playerId) {
        Optional<Player> playerOptinal = playerRepository.findById(playerId);
        if(playerOptinal.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player id");
        }
        Player player = playerOptinal.get();
        return PlayerConvertor.playerToPlayerResponse(player);
    }

    public List<PlayerResponse> getPlayerByGender(Gender gender) {
        List<Player> players = playerRepository.findByGender(gender);

        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }

        return playerResponses;
    }

    public List<PlayerResponse> getPlayerByGenderAndSpeciality(Gender gender,
                                                               Speciality speciality) {
        List<Player> players = playerRepository.findPlayerBasedOnGenderAndSpeciality(gender,speciality);

        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }

        return playerResponses;
    }
}
