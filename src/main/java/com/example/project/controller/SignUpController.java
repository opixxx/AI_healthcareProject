package com.example.project.controller;

import com.example.project.Service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping("/signup")
    public String signUpForm(@ModelAttribute("signUpForm") SignUpForm form) {

        return "members/signup";
    }

    @PostMapping("/signup")
    public String signUp(@Validated @ModelAttribute("signUpForm") SignUpForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "members/signup";
        }

        try {
            signUpService.signUp(form);
        }catch (IllegalArgumentException e) {
            bindingResult.rejectValue("loginId", "duplicate", e.getMessage());
            return "members/signup";
        }

        return "redirect:/login";
    }
}
