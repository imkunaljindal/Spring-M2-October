package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.MatchConvertor;
import com.example.CricBuzz.dto.request.CricketMatchRequest;
import com.example.CricBuzz.dto.response.CricketMatchResponse;
import com.example.CricBuzz.dto.response.TeamResponse;
import com.example.CricBuzz.exception.CricketMatchRepo;
import com.example.CricBuzz.exception.TeamNotFoundException;
import com.example.CricBuzz.model.CricketMatch;
import com.example.CricBuzz.model.Team;
import com.example.CricBuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CricketMatchRepo cricketMatchRepo;

    public CricketMatchResponse registerMatch(CricketMatchRequest cricketMatchRequest,
                                              int teamAId,
                                              int teamBId) {

        Optional<Team> optionalTeamA = teamRepository.findById(teamAId);
        Optional<Team> optionalTeamB = teamRepository.findById(teamBId);

        if(optionalTeamA.isEmpty() || optionalTeamB.isEmpty()) {
            throw new TeamNotFoundException("Invalid team details");
        }

        Team teamA = optionalTeamA.get();
        Team teamB = optionalTeamB.get();

        CricketMatch match = MatchConvertor.cricketMatchRequestToCricketMatch(cricketMatchRequest);

        List<Team> teams = List.of(teamA,teamB);
        match.setTeams(teams);

        teamA.getMatches().add(match);
        teamB.getMatches().add(match);

        CricketMatch savedMatch = cricketMatchRepo.save(match);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConvertor.cricketMatchToCricketMatchResponse(savedMatch);
    }
}
