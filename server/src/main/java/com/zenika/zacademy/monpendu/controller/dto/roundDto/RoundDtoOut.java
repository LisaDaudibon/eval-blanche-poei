package com.zenika.zacademy.monpendu.controller.dto.roundDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundDtoOut {
    @NotBlank
    private UUID id;
    @NotBlank
    @Size(max = 50, message = "Le champ word ne doit pas dépasser 20 caractères")
    private String roundWord;
    @NotBlank
    private List lettersSearched;
    @NotNull
    private int attempt;
    @NotNull
    private String state;
    @NotNull
    @Size(max = 250, message = "Le champ gameDescription ne doit pas dépasser 250 caractères")
    private String gameDescription;
}
