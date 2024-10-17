package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.CricketMatchRequest;
import com.example.CricBuzz.exception.TeamNotFoundException;
import com.example.CricBuzz.model.Enum.MatchType;
import com.example.CricBuzz.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @PostMapping
    public ResponseEntity registerMatch(@RequestBody CricketMatchRequest cricketMatchRequest,
                                        @RequestParam("teamA-id") int teamAId,
                                        @RequestParam("teamB-id") int teamBId) {
        try{
            return new ResponseEntity<>(matchService.registerMatch(cricketMatchRequest,teamAId,teamBId), HttpStatus.CREATED);
        }
        catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
