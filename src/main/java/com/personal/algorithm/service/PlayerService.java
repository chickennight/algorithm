package com.personal.algorithm.service;

import com.personal.algorithm.dto.PlayerDTO;
import com.personal.algorithm.entity.Player;
import com.personal.algorithm.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerPlayer(PlayerDTO playerDTO) {
        Player player = playerDTO.toEntity();
        player.encodePassword(passwordEncoder);
        playerRepository.save(player);
    }
}
