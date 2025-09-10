package com.rodrigo.tennisapi.controller;

import com.rodrigo.tennisapi.dto.PlayerDTO;
import com.rodrigo.tennisapi.entity.Player;
import com.rodrigo.tennisapi.exception.ResourceNotFoundException;
import com.rodrigo.tennisapi.mapper.PlayerMapper;
import com.rodrigo.tennisapi.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> players = playerService.getAllPlayers()
                .stream().map(PlayerMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayer(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found: " + id));
        return ResponseEntity.ok(PlayerMapper.toDTO(player));
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        Player player = PlayerMapper.toEntity(playerDTO);
        Player saved = playerService.savePlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(PlayerMapper.toDTO(saved));
    }

}
