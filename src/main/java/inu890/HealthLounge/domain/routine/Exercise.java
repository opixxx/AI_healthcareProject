package inu890.HealthLounge.domain.routine;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;
    private String name;

    @OneToMany(mappedBy = "exercise")
    private List<RoutineDetail> routineDetails;
}