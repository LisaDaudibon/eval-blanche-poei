package com.zenika.zacademy.monpendu.controller;

import com.zenika.zacademy.monpendu.controller.dto.roundDto.RoundDtoOut;
import com.zenika.zacademy.monpendu.controller.dto.roundDto.RoundMapper;
import com.zenika.zacademy.monpendu.service.RoundService;
import com.zenika.zacademy.monpendu.service.exception.NotFoundException;
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
    @GetMapping
    public List<RoundDtoOut> findAll() {
        return this.roundService.findAll().stream()
                .map(roundMapper::toDto)
                .toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RoundDtoOut findById(@PathVariable UUID id ) throws NotFoundException {
        return this.roundMapper.toDto(this.roundService.findOneById(id));
    }
}
