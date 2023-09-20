package com.example.project.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id")
    private Long routineId;

    private int version;

    @Enumerated(EnumType.STRING)
    private Days dayCount;

    @Enumerated(EnumType.STRING)
    private Part part;

    @Enumerated(EnumType.STRING)
    private FitnessLevel level;
}
