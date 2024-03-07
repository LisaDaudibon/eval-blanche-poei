package com.zenika.zacademy.monpendu.service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "round")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="attempt", nullable = false)
    private Integer attempt;

    @Column(name="letters_searched", nullable = false, length = 30)
    private String lettersSearched;

    @Column(name="state", nullable = false, length = 30)
    private String state;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "game_id")
    private Game game;
}
