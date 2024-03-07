package com.zenika.zacademy.monpendu.service;

import com.zenika.zacademy.monpendu.repository.GameRepository;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import com.zenika.zacademy.monpendu.service.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> findAll () {
        return this.gameRepository.findAll();
    }

    public Game findById (UUID id) throws NotFoundException {
        return this.gameRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
