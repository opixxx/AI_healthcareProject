package com.example.project.repository;

import com.example.project.domain.Routine;
import com.example.project.domain.RoutineDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoutineDetailRepository extends JpaRepository<RoutineDetail, Long> {
    List<RoutineDetail> findByRoutine(Routine routine);
}
