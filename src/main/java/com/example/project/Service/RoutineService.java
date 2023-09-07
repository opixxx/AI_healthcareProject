package com.example.project.Service;

import com.example.project.domain.Days;
import com.example.project.domain.FitnessLevel;
import com.example.project.domain.Routine;
import com.example.project.domain.RoutineDetail;
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

    @Transactional
    public List<RoutineDetail> getRandomRoutineDetailsByDayCountAndLevel(Days dayCount, FitnessLevel level) {
        List<Routine> routines = routineRepository.findByDayCountAndLevel(dayCount, level);

        Random random = new Random();
        Routine selectRoutine = routines.get(random.nextInt(routines.size()));

        return selectRoutine.getRoutineDetails();
    }

}
