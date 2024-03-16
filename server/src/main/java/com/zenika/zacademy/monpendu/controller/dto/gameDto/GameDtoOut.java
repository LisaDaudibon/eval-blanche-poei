package com.zenika.zacademy.monpendu.controller.dto.gameDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameDtoOut {
    @NotBlank
    private UUID id;
    @NotBlank
    @Size(max = 250, message = "Le champ description ne doit pas dépasser 250 caractères")
    private String description;
    @NotBlank
    private String createdBy;
}
