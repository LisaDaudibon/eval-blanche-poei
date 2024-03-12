package com.zenika.zacademy.monpendu.controller.dto.roundDto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoundDtoOut {
    private UUID id;
    private String roundWord;
    private List lettersSearched;
    private int attempt;
    private String state;
    private String gameDescription;
}
