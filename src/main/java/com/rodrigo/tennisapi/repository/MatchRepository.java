package com.rodrigo.tennisapi.repository;

import com.rodrigo.tennisapi.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {}