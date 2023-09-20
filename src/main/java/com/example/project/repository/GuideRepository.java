package com.example.project.repository;

import com.example.project.domain.ExerciseType;
import com.example.project.domain.GuideVideo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuideRepository extends JpaRepository<GuideVideo, Long> {

    Optional<GuideVideo> findByExerciseType(ExerciseType exerciseType);
}
