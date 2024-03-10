package com.zenika.zacademy.monpendu.controller.dto.roundDto;

import com.zenika.zacademy.monpendu.service.GameService;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import com.zenika.zacademy.monpendu.service.model.Round;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class RoundMapper {
    private final GameService gameService;

    public RoundDtoOut toDto (Round from) {
        return RoundDtoOut.builder()
                .id(from.getId())
                .attempt(from.getAttempt())
                .lettersSearched(from.getLettersSearched())
                .gameId(from.getGame().getId())
                .gameDescription(from.getGame().getDescription())
                .build();
    }

    public Round toModel (RoundDtoIn from) throws NotFoundException {
        return Round.builder()
                .lettersSearched(from.getLetterSearched())
                .game(this.gameService.findById(from.getGameId()))
                .build();
    }


}
