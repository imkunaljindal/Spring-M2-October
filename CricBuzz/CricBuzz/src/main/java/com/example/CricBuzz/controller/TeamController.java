package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.TeamRequest;
import com.example.CricBuzz.dto.response.TeamResponse;
import com.example.CricBuzz.service.TeamService;
import jakarta.persistence.PostLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping
    public TeamResponse addTeam(@RequestBody TeamRequest teamRequest) {
        return teamService.addTeam(teamRequest);
    }
}
