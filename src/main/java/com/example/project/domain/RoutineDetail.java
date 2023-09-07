package com.example.project.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class RoutineDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_detail_id")
    private Long routineDetailId;
    private int day;
    private int sets;
    private int reps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routineId")
    private Routine routine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseId")
    private Exercise exercise;
}

