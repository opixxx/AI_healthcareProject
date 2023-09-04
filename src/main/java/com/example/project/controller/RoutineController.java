//package com.example.project.controller;
//
//import com.example.project.domain.Routine;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/routine")
//@RequiredArgsConstructor
//public class RoutineController {
//    private RoutineService routineService;
//
//    @GetMapping("/recommend")
//    public Routine getRecommendedRoutine(@RequestParam int days, @RequestParam String level) {
//        return routineService.getRoutineByCondition(days, level);
//    }
//}
