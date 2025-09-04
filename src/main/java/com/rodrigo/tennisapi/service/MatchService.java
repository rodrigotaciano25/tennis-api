package com.rodrigo.tennisapi.service;

import com.rodrigo.tennisapi.entity.Match;
import com.rodrigo.tennisapi.entity.Player;
import com.rodrigo.tennisapi.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match findById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public List<Match> findByTournamentName(String tournamentName) {
        return matchRepository.findByTournamentName(tournamentName);
    }

    public List<Match> getMatchesByWinner(Player winner) {
        return matchRepository.findByWinner(winner);
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        return matchRepository.findById(id).map(existing -> {
            existing.setTournamentName(updatedMatch.getTournamentName());
            existing.setRound(updatedMatch.getRound());
            existing.setWinner(updatedMatch.getWinner());
            existing.setPlayers(updatedMatch.getPlayers());
            return matchRepository.save(existing);
        }).orElse(null);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
