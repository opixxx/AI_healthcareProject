package inu890.HealthLounge.web.analysis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AnalysisController {

    @GetMapping("/analysis")
    public String analysis() {
        return "analysis/analysis";
    }
}
