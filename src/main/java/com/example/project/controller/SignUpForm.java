package com.example.project.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpForm {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    private String gender;
}
