package com.zenika.zacademy.monpendu.service;

import com.zenika.zacademy.monpendu.repository.RoundRepository;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
import com.zenika.zacademy.monpendu.service.model.Round;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoundService {
    private RoundRepository roundRepository;

    public RoundService ( RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    public List<Round> findAll () {
        return this.roundRepository.findAll();
    }

    private Round findOneById (UUID id) throws NotFoundException {
        return this.roundRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
