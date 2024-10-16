package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.TeamConvertor;
import com.example.CricBuzz.dto.request.TeamRequest;
import com.example.CricBuzz.dto.response.TeamResponse;
import com.example.CricBuzz.model.Team;
import com.example.CricBuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public TeamResponse addTeam(TeamRequest teamRequest) {
        Team team = TeamConvertor.teamRequestToTeam(teamRequest);
        Team savedTeam = teamRepository.save(team);
        return TeamConvertor.teamToTeamResponse(savedTeam);
    }
}
