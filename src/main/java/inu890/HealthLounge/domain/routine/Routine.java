package inu890.HealthLounge.domain.routine;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

}