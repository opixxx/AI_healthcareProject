package com.example.project.Service;

import com.example.project.domain.Routine;
import com.example.project.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoutineService {
    private RoutineRepository routineRepository;

    public Routine getRoutineByCondition(int days, String level) {
        return routineRepository.findByDaysAndLevel(days, level);
    }
}
