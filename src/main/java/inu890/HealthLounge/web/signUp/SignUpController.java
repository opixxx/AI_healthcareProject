package inu890.HealthLounge.web.signUp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    @GetMapping("signup")
    public String signUpForm() {
        return "members/signup";
    }
}
