package com.example.CricBuzz.model;

import com.example.CricBuzz.model.Enum.Gender;
import com.example.CricBuzz.model.Enum.Speciality;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    @ManyToOne
    @JoinColumn
    Team team;

    @OneToOne(mappedBy = "player")
    Stats stats;
}

