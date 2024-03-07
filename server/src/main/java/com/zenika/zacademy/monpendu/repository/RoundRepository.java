package com.zenika.zacademy.monpendu.repository;

import com.zenika.zacademy.monpendu.service.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoundRepository extends JpaRepository<Round, UUID> {
}
