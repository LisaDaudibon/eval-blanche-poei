package com.zenika.zacademy.monpendu.service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "uuid")

@Entity
@Table(name = "round")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name="attempt")
    private Integer atttempt;

    @Column(name="state")
    private String state;

    @OneToOne
    @JoinColumn(name= "game_uuid")
    private Game game;
}
