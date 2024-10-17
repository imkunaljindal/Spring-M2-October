package com.example.CricBuzz.convertor;

import com.example.CricBuzz.dto.request.CricketMatchRequest;
import com.example.CricBuzz.dto.response.CricketMatchResponse;
import com.example.CricBuzz.dto.response.TeamResponse;
import com.example.CricBuzz.exception.CricketMatchRepo;
import com.example.CricBuzz.model.CricketMatch;

import java.util.ArrayList;
import java.util.List;

public class MatchConvertor {

    public static CricketMatch cricketMatchRequestToCricketMatch(CricketMatchRequest matchRequest) {
        return CricketMatch.builder()
                .title(matchRequest.getTitle())
                .matchType(matchRequest.getMatchType())
                .overs(matchRequest.getOvers())
                .place(matchRequest.getPlace())
                .build();
    }

    public static CricketMatchResponse cricketMatchToCricketMatchResponse(CricketMatch match) {

        List<TeamResponse> teamResponseList = new ArrayList<>();
        TeamResponse teamResponseA = TeamConvertor.teamToTeamResponse(match.getTeams().get(0));
        TeamResponse teamResponseB = TeamConvertor.teamToTeamResponse(match.getTeams().get(1));
        teamResponseList.add(teamResponseA);
        teamResponseList.add(teamResponseB);

        return CricketMatchResponse.builder()
                .title(match.getTitle())
                .matchType(match.getMatchType())
                .overs(match.getOvers())
                .place(match.getPlace())
                .startedAt(match.getStartedAt())
                .teams(teamResponseList)
                .build();
    }
}
