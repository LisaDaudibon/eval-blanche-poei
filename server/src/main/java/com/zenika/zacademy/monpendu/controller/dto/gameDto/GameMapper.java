package com.zenika.zacademy.monpendu.controller.dto.gameDto;

import com.zenika.zacademy.monpendu.service.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    public GameDtoOut toDto (Game from) {
        return GameDtoOut.builder()
                .id(from.getId())
                .wordToGuess(from.getWordToGuess())
                .description(from.getDescription())
                .build();
    }
}
