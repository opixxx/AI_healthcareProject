package inu890.HealthLounge.domain.analysis;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuideRepository extends JpaRepository<GuideVideo, Long> {

    Optional<GuideVideo> findByExerciseType(ExerciseType exerciseType);
}
