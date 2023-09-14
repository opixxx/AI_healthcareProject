package inu890.HealthLounge.web.routine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
