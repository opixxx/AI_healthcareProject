package com.example.project.repository;

import com.example.project.domain.Days;
import com.example.project.domain.FitnessLevel;
import com.example.project.domain.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    @Query("select r.routineId" +
            " from Routine r" +
            " where r.dayCount = :days and r.level = :level")
    List<Long> findRoutineIdByDayCountAndLevel(@Param("days") Days days, @Param("level") FitnessLevel level);

}
