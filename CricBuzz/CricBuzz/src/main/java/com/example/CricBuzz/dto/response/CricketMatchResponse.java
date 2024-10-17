package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.model.Enum.MatchType;
import com.example.CricBuzz.model.Team;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CricketMatchResponse {

    String title;

    MatchType matchType;

    int overs;

    String place;

    Date startedAt;

    List<TeamResponse> teams;
}
