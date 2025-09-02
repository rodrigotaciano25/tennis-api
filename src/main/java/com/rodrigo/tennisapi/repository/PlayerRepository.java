package com.rodrigo.tennisapi.repository;

import com.rodrigo.tennisapi.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {}
