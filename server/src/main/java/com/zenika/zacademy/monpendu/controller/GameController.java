package com.zenika.zacademy.monpendu.controller;

import com.zenika.zacademy.monpendu.controller.dto.gameDto.GameDtoIn;
import com.zenika.zacademy.monpendu.controller.dto.gameDto.GameDtoOut;
import com.zenika.zacademy.monpendu.controller.dto.gameDto.GameMapper;
import com.zenika.zacademy.monpendu.service.GameService;
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

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    private final GameMapper gameMapper;

    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @GetMapping
    @Operation(summary = "Get all games")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The games found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GameDtoOut[].class))})
    })
    @ResponseStatus(HttpStatus.OK)
    public List<GameDtoOut> findAll() {
        logger.info("Show a list of all games");
        return this.gameService.findAll().stream()
                .map(gameMapper::toDto)
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a game from its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The game found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GameDtoOut.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Game not found", content = @Content)
    })
    @GetMapping("/{id}")
    public GameDtoOut findById(@PathVariable UUID id) throws NotFoundException {
        logger.info("Show the game with id ${id}");
        return this.gameMapper.toDto(this.gameService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new round")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The round created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GameDtoOut.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid round object supplied", content = @Content),
    })
    @PostMapping("/{id}/rounds")
    public UUID create( @PathVariable UUID id ) throws NotFoundException {
        logger.info("Create a new round");
        return this.gameService.createRound(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new game")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "The game created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GameDtoOut.class))}),
//            @ApiResponse(responseCode = "400", description = "Invalid game object supplied", content = @Content),
//    })
    @PostMapping
    public GameDtoOut create (@RequestBody GameDtoIn game) {
        return this.gameMapper.toDto(this.gameService.create(this.gameMapper.toModel(game)));
    }
}
