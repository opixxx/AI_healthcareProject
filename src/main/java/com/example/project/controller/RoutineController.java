package com.example.project.controller;


import com.example.project.InitDb;
import com.example.project.Service.RoutineFinalService;
import com.example.project.Service.RoutineService;
import com.example.project.domain.Days;
import com.example.project.domain.FitnessLevel;
import com.example.project.domain.RoutineDetail;
import com.example.project.domain.RoutineFinal;
import com.example.project.repository.RoutineRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RoutineController {

    private final RoutineFinalService routineFinalService;
    private final RoutineService routineService;

    private final RoutineRepository routineRepository;
    @GetMapping("/routine")
    public String routine() {
        return "routine/routine";
    }



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









    // 뻘짓
//    @GetMapping("/routines")
//    public List<RoutineFinal> getAllRoutines() {
//        return routineFinalService.findAllRoutines();
//    }

//    @GetMapping("/api/routine")
//    public Result<Map<Integer, List<RoutineFinalDto>>> routinesByDay() {
//        List<RoutineFinal> findRoutine = routineFinalService.findAllRoutines();
//        Map<Integer, List<RoutineFinalDto>> collect = findRoutine.stream()
//                .collect(Collectors.groupingBy(RoutineFinal::getDay,
//                        Collectors.mapping(r -> new RoutineFinalDto(r.getExerciseName(), r.getSets(), r.getReps()),
//                                Collectors.toList())));
//        return new Result(collect);
//    }
//
//
//    @Data
//    @AllArgsConstructor
//    static class RoutineFinalDto {
//
//        private String exerciseName;
//        private int sets;
//        private int reps;
//    }
//    @Data
//    @AllArgsConstructor
//    static class Result<T> {
//        private T day;
//    }

    @Data
    @AllArgsConstructor
    static class RoutineDetailDTO {
        private int day;
        private String exerciseName;
        private int sets;
        private int reps;
    }




}
