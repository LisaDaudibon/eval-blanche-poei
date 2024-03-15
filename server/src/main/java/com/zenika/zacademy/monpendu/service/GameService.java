package com.zenika.zacademy.monpendu.service;

import com.zenika.zacademy.monpendu.repository.GameRepository;
import com.zenika.zacademy.monpendu.repository.RoundRepository;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import com.zenika.zacademy.monpendu.service.model.Game;
import com.zenika.zacademy.monpendu.service.model.Round;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final RoundRepository roundRepository;

    public List<Game> findAll () {
        return this.gameRepository.findAll();
    }

    public Game findById (UUID id) throws NotFoundException {
        return this.gameRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public UUID createRound (UUID id) throws NotFoundException{
        return this.roundRepository.save(Round.builder().game(this.findById(id)).build()).getId();
    }

    public Game create (Game game) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        game.setCreatedBy(authentication.getName());
        return this.gameRepository.save(game);
    }
}
