package com.example.project.domain;

import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDetail {
    private String exercise;
    private int sets;
    private int reps;

}

