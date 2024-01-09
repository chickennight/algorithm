package com.personal.algorithm.controller;

import com.personal.algorithm.dto.PlayerDTO;
import com.personal.algorithm.service.PlayerService;
import com.personal.algorithm.util.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;
    private final ErrorHandler errorHandler;

    public PlayerController(PlayerService playerService, ErrorHandler errorHandler) {
        this.playerService = playerService;
        this.errorHandler = errorHandler;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerPlayer(@RequestBody PlayerDTO playerDTO) {
        try {
            playerService.registerPlayer(playerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return errorHandler.errorMessage(e);
        }
    }
}
