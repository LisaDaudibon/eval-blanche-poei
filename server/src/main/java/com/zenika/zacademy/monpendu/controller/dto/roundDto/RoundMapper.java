package com.zenika.zacademy.monpendu.controller.dto.roundDto;

import com.zenika.zacademy.monpendu.service.model.Round;
import org.springframework.stereotype.Component;

@Component
public class RoundMapper {
    public RoundDtoOut toDto (Round from) {
        return RoundDtoOut.builder()
                .id(from.getId())
                .attempt(from.getAttempt())
                .lettersSearched(from.getLettersSearched())
                .build();
    }
}
