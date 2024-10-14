package com.example.CricBuzz.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String teamName;

    int ranking;

    int iccPoints;

    @OneToMany(mappedBy = "team")
    List<Player> players = new ArrayList<>();

    @ManyToMany(mappedBy = "teams")
    List<CricketMatch> matches = new ArrayList<>();
}
