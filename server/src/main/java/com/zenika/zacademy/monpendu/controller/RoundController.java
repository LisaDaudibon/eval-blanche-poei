package com.zenika.zacademy.monpendu.controller;

import com.zenika.zacademy.monpendu.controller.dto.roundDto.RoundDtoOut;
import com.zenika.zacademy.monpendu.controller.dto.roundDto.RoundMapper;
import com.zenika.zacademy.monpendu.service.RoundService;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@RequestMapping("/rounds")
@RestController
public class RoundController {
    private final Logger logger = LoggerFactory.getLogger(RoundController.class);

    private final RoundService roundService;
    private final RoundMapper roundMapper;

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all rounds ever created")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The rounds found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RoundDtoOut[].class))})
    })
    @GetMapping
    public List<RoundDtoOut> findAll() {
        return this.roundService.findAll().stream()
                .map(roundMapper::toDto)
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a round from its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The round found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RoundDtoOut.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Round not found", content = @Content)
    })
    @GetMapping("/{id}")
    public RoundDtoOut findById(@PathVariable UUID id ) throws NotFoundException {
        return this.roundMapper.toDto(this.roundService.findOneById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Play a letter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The letter is added to the list of letters", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RoundDtoOut.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid letter object supplied", content = @Content),
    })
    @PostMapping("/{id}/searched/{c}")
    public RoundDtoOut updateLetterGuessed ( @PathVariable UUID id, @PathVariable("c") String letterGuessed ) throws NotFoundException {
        logger.info("Play a letter");
        return this.roundMapper.toDto(this.roundService.guessedLetter(id, letterGuessed));
    }

}
