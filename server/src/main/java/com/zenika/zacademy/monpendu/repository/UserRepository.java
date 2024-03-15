package com.zenika.zacademy.monpendu.repository;

import com.zenika.zacademy.monpendu.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
}
