package com.example.project.repository;

import com.example.project.domain.ExerciseVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRepository extends JpaRepository<ExerciseVideo, Long> {

}

