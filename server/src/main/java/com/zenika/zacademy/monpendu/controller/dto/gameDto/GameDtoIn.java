package com.zenika.zacademy.monpendu.controller.dto.gameDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameDtoIn {
    @NotBlank
    @Size(max = 50, message = "Le champ word ne doit pas dépasser 50 caractères")
    private String wordToGuess;
    @NotBlank
    @Size(max = 255, message = "Le champ description ne doit pas dépasser 255 caractères")
    private String description;
}
