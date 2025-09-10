package com.rodrigo.tennisapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MatchDTO {
    private Long id;
    private String tournamentName;
    private String round;
    private String score;
    private List<PlayerNameRankDTO> players;
    private WinnerDTO winner;
}
