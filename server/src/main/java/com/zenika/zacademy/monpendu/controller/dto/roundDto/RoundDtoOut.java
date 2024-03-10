package com.zenika.zacademy.monpendu.controller.dto.roundDto;

import com.zenika.zacademy.monpendu.service.model.Game;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundDtoOut {
    private UUID id;
    private String lettersSearched;
    private int attempt;
    private UUID gameId;
    private String gameDescription;
}
