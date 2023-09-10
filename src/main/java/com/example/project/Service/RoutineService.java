package com.example.project.Service;

import com.example.project.domain.Days;
import com.example.project.domain.FitnessLevel;
import com.example.project.repository.RoutineDetailRepository;
import com.example.project.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final RoutineDetailRepository routineDetailRepository;

    @Transactional
    public List<Object[]> getRandomRoutineDetailsByDayCountAndLevel(Days dayCount, FitnessLevel level) {
        List<Long> routineIds = routineRepository.findRoutineIdByDayCountAndLevel(dayCount, level);

        if (routineIds.isEmpty()) {
            throw new IllegalArgumentException("조건에 맞는 루틴이 없습니다.");
        }

        Random random = new Random();
        Long selectedRoutineId = routineIds.get(random.nextInt(routineIds.size()));

        return routineDetailRepository.findDetailsWithExerciseNameByRoutineId(selectedRoutineId);
    }


}

