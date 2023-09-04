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

    @ManyToOne
    @JoinColumn(name = "routineId")
    private Routine routine;

    @ManyToOne
    @JoinColumn(name = "exerciseId")
    private Exercise exercise;
}

