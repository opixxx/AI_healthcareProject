package inu890.HealthLounge.domain.routine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineDetailRepository extends JpaRepository<RoutineDetail, Long> {
    @Query("select rd.day, e.name, rd.sets, rd.reps" +
            " from RoutineDetail rd" +
            " join rd.exercise e" +
            " where rd.routine.routineId = :routineId")
    List<Object[]> findDetailsWithExerciseNameByRoutineId(@Param("routineId") Long routineId);

}