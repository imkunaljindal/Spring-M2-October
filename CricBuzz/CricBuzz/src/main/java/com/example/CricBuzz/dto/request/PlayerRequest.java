package com.example.CricBuzz.dto.request;

import com.example.CricBuzz.model.Enum.Gender;
import com.example.CricBuzz.model.Enum.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerRequest {

    String name;

    int age;

    Gender gender;

    Speciality speciality;
}
