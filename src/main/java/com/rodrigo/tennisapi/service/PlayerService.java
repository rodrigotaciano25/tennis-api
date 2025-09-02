package com.rodrigo.tennisapi.service;

import com.rodrigo.tennisapi.entity.Player;
import com.rodrigo.tennisapi.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player findByName(String name) {
        return playerRepository.findByName(name).orElse(null);
    }

    public Player findById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}