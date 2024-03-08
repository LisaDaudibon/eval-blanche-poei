package com.zenika.zacademy.monpendu.service;

import com.zenika.zacademy.monpendu.repository.RoundRepository;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import com.zenika.zacademy.monpendu.service.model.Round;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class RoundService {
    private final RoundRepository roundRepository;

    public List<Round> findAll () {
        return this.roundRepository.findAll();
    }

    public Round findOneById (UUID id) throws NotFoundException {
        return this.roundRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
