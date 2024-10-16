package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.model.Enum.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerResponse {

    String name;
    Speciality speciality;
}
