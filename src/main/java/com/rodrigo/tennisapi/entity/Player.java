package com.rodrigo.tennisapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String country;
    private String gender;
    private int rank;
    private int careerHighestRank;
    private int titles;
    private Long prizeMoney;
    private int turnedPro;
    private double height;
    private double weight;

    @ManyToMany(mappedBy = "players")
    @JsonIgnore
    private List<Match> matches;

    @JsonIgnore
    @OneToMany(mappedBy = "winner")
    private List<Match> wins;
}
