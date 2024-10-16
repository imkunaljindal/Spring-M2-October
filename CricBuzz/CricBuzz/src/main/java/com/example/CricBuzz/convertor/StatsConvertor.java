package com.example.CricBuzz.convertor;

import com.example.CricBuzz.dto.request.StatsRequest;
import com.example.CricBuzz.model.Stats;

public class StatsConvertor {

    public static Stats statsRequestToStats(StatsRequest statsRequest) {
        return Stats.builder()
                .battingAverage(statsRequest.getBattingAverage())
                .bowlingAverage(statsRequest.getBowlingAverage())
                .wicketsTaken(statsRequest.getWicketsTaken())
                .runsScored(statsRequest.getRunsScored())
                .build();
    }
}
