package com.zenika.zacademy.monpendu.service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of="id")

@Entity
@Table(name = "answered_letter")
public class AnsweredLetter {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "round_uuid")
    private Round roundUuid;
}
