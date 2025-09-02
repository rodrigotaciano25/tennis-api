package com.rodrigo.tennisapi.service;

import com.rodrigo.tennisapi.entity.Player;
import com.rodrigo.tennisapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id){
        return playerRepository.findById(id).orElse(null);
    }

    public Player createPlayer(Player player){
        return playerRepository.save(player);
    }

    public Player updatePlayer(Player player){
        Player existingPlayer = getPlayerById(player.getId());
        if (existingPlayer != null){
            existingPlayer.setName(player.getName());
            existingPlayer.setRank(player.getRank());
            if (existingPlayer.getRank() > player.getCareerHighestRank()){
                existingPlayer.setCareerHighestRank(player.getCareerHighestRank());
            }
            existingPlayer.setTitles(player.getTitles());
            existingPlayer.setPrizeMoney(player.getPrizeMoney());
            return playerRepository.save(existingPlayer);
        } else {
            return null;
        }
    }

    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }
}