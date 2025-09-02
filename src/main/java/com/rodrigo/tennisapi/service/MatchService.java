package com.rodrigo.tennisapi.service;

import com.rodrigo.tennisapi.entity.Match;
import com.rodrigo.tennisapi.repository.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match findById(Long id){
        return matchRepository.findById(id).orElse(null);
    }

}
