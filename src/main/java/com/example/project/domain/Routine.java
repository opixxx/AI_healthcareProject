package com.example.project.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

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
    private FitnessLevel level;

    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL)
    private List<RoutineDetail> routineDetails;

}
