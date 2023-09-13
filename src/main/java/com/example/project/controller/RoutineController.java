package com.example.project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class RoutineController {


    @GetMapping("/routine")
    public String routine() {
        return "routine/routine";
    }

    @GetMapping("/routineList")
    public String showRoutineList() {
        return "routine/routineList";
    }

}
