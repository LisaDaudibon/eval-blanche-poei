package com.zenika.zacademy.monpendu.controller.dto.roundDto;

import com.zenika.zacademy.monpendu.service.model.Game;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class RoundDtoIn {
    private String letterSearched;
    private UUID gameId;
}
