package com.zenika.zacademy.monpendu.controller.dto.roundDto;

import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import com.zenika.zacademy.monpendu.service.model.Round;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor

@Component
public class RoundMapper {

    public RoundDtoOut toDto (Round from) {
        return RoundDtoOut.builder()
                .id(from.getId())
                .attempt(from.getAttempt())
                .roundWord(from.getRoundWord())
                .lettersSearched(from.getLettersSearched())
                .state(from.getState())
                .gameDescription(from.getGame().getDescription())
                .build();
    }

    public Round toModel (RoundDtoIn from) throws NotFoundException {
        return Round.builder()
                .lettersSearched(from.getLetterSearched())
                .build();
    }
}
