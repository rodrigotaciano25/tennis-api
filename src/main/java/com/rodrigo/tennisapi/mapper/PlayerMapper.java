package com.rodrigo.tennisapi.mapper;

import com.rodrigo.tennisapi.dto.PlayerDTO;
import com.rodrigo.tennisapi.entity.Player;

public class PlayerMapper {
    public static PlayerDTO toDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setAge(player.getAge());
        return dto;
    }

    public static Player toEntity(PlayerDTO dto) {
        Player player = new Player();
        player.setId(dto.getId());
        player.setName(dto.getName());
        player.setAge(dto.getAge());
        return player;
    }
}
