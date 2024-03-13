package com.zenika.zacademy.monpendu.controller;

import com.zenika.zacademy.monpendu.controller.dto.gameDto.GameDtoOut;
import com.zenika.zacademy.monpendu.repository.GameRepository;
import com.zenika.zacademy.monpendu.service.GameService;
import com.zenika.zacademy.monpendu.service.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameService gameService;
    @LocalServerPort
    private int port;

    @Test
    public void shouldFindGameById() {
        List<Game> games = this.gameRepository.findAll();
        Game firstGame = games.getFirst();
        ResponseEntity<GameDtoOut> responseEntity = restTemplate
                .getForEntity(
                        "http://localhost:" + port + "/api/games/" +firstGame.getId().toString(), GameDtoOut.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getId()).isEqualTo(firstGame.getId());
    }

    
}
