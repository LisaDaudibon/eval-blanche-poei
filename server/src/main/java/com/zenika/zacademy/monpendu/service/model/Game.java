package com.zenika.zacademy.monpendu.service.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of="id")

@Entity
@Table(name="game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="word_to_guess", nullable = false, length = 50)
    private String wordToGuess;

    @Column(name="description")
    private String description;

//    @OneToMany(mappedBy = "game")
//    private List<Tip> tips = new ArrayList<>();
}
