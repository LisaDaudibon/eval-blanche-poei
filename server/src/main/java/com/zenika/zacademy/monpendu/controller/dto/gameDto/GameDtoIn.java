package com.zenika.zacademy.monpendu.controller.dto.gameDto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameDtoIn {
    private String wordToGuess;
    private String description;

}
