package com.example.project.api;

import com.example.project.Service.RoutineService;
import com.example.project.domain.Days;
import com.example.project.domain.FitnessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RoutineApiController {
    private final RoutineService routineService;
    @GetMapping("/recommand")
    public List<RoutineDetailDTO> getRoutineDetails(
            @RequestParam Days dayCount,
            @RequestParam FitnessLevel level) {

        List<Object[]> results = routineService.getRandomRoutineDetailsByDayCountAndLevel(dayCount, level);

        // Object[]를 RoutineDetailDTO로 변환
        List<RoutineDetailDTO> routineDetails = results.stream().map(routine ->
                new RoutineDetailDTO((Integer) routine[0], (String) routine[1], (Integer) routine[2], (Integer) routine[3])
        ).collect(Collectors.toList());

        return routineDetails;
    }

    @Data
    @AllArgsConstructor
    static class RoutineDetailDTO {
       private int day;
        private String exerciseName;
        private int sets;
        private int reps;
    }

}
