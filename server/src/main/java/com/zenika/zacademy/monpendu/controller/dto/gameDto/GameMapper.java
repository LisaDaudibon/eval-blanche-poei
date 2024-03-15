package com.zenika.zacademy.monpendu.controller.dto.gameDto;

import com.zenika.zacademy.monpendu.service.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    public GameDtoOut toDto (Game from) {
        return GameDtoOut.builder()
                .id(from.getId())
                .description(from.getDescription())
                .createdBy(from.getCreatedBy())
                .build();
    }

    public Game toModel (GameDtoIn from) {
        return Game.builder()
                .wordToGuess(from.getWordToGuess())
                .description(from.getDescription())
                .build();
    }
}
