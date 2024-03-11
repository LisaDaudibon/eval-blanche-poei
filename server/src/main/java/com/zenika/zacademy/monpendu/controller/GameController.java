package com.zenika.zacademy.monpendu.controller;

import com.zenika.zacademy.monpendu.controller.dto.gameDto.GameDtoOut;
import com.zenika.zacademy.monpendu.controller.dto.gameDto.GameMapper;
import com.zenika.zacademy.monpendu.service.GameService;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    private final GameMapper gameMapper;

    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameDtoOut> findAll() {
        logger.info("Show a list of all games");
        return this.gameService.findAll().stream()
                .map(gameMapper::toDto)
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public GameDtoOut findById(@PathVariable UUID id) throws NotFoundException {
        logger.info("Show the game with id ${id}");
        return this.gameMapper.toDto(this.gameService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/rounds")
    public UUID create( @PathVariable UUID id ) throws NotFoundException {
        logger.info("Create a new round");
        return this.gameService.createRound(id);
    }
}
