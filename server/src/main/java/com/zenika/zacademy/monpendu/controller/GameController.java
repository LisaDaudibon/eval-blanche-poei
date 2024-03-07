package com.zenika.zacademy.monpendu.controller;

import com.zenika.zacademy.monpendu.controller.dto.gameDto.GameDtoOut;
import com.zenika.zacademy.monpendu.controller.dto.gameDto.GameMapper;
import com.zenika.zacademy.monpendu.service.GameService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return this.gameService.findAll().stream()
                .map(gameMapper::toDto)
                .toList();
    }
}
