package com.zenika.zacademy.monpendu.service.model;

import com.zenika.zacademy.monpendu.repository.SearchLettersConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
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
    @Builder.Default
    private Integer attempt = 0;


    @Column(name="letters_searched", nullable = false, length = 50)
    @Convert(converter = SearchLettersConverter.class)
    @Builder.Default
    private List<String> lettersSearched = new ArrayList<>();

    @Builder.Default
    @Column(name="state", nullable = false, length = 30)
    private String state = "ONGOING";

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "game_id")
    private Game game;

    @Transient
    private String roundWord;
}
