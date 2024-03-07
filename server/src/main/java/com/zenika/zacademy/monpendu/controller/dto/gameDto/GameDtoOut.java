package com.zenika.zacademy.monpendu.controller.dto.gameDto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameDtoOut {
    private UUID id;
    private String description;
    private String wordToGuess;
}
