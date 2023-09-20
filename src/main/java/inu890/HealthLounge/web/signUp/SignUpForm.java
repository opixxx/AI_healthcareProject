package inu890.HealthLounge.web.signUp;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data

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
