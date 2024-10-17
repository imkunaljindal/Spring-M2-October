package com.example.CricBuzz.dto.request;

import com.example.CricBuzz.model.Enum.MatchType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CricketMatchRequest {

    String title;

    MatchType matchType;

    int overs;

    String place;
}
