package com.example.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
public class RoutineFinal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routineFinalId;

    private int day;

    private String exerciseName;

    private int sets;

    private int reps;



}
