package com.example.project.repository;

import com.example.project.domain.Days;
import com.example.project.domain.FitnessLevel;
import com.example.project.domain.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Routine findByDayCountAndLevel(Days days, FitnessLevel level);
}
