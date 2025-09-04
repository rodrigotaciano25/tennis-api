package com.rodrigo.tennisapi.repository;

import com.rodrigo.tennisapi.entity.Match;
import com.rodrigo.tennisapi.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByTournamentName(String tournamentName);
    List<Match> findByWinner(Player winner);
}
