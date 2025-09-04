package com.rodrigo.tennisapi.controller;

import com.rodrigo.tennisapi.entity.Match;
import com.rodrigo.tennisapi.entity.Player;
import com.rodrigo.tennisapi.service.MatchService;
import com.rodrigo.tennisapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match createdMatch = matchService.createMatch(match);
        return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        return new ResponseEntity<>(matchService.getAllMatches(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Match match = matchService.findById(id);
        return match != null ? new ResponseEntity<>(match, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tournament/{name}")
    public ResponseEntity<List<Match>> getMatchesByTournament(@PathVariable String name) {
        return new ResponseEntity<>(matchService.findByTournamentName(name), HttpStatus.OK);
    }

    @GetMapping("/winner/{playerId}")
    public ResponseEntity<List<Match>> getMatchesByWinner(@PathVariable Long playerId) {
        Player winner = playerService.getPlayerById(playerId);
        if (winner != null) {
            return new ResponseEntity<>(matchService.getMatchesByWinner(winner), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
