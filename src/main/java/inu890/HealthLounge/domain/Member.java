package inu890.HealthLounge.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Member {

    private long id;    //DB에 저장할 ID

    @NotEmpty
    private String LoginId;   //로그인ID

    @NotEmpty
    private String Name;

    @NotEmpty
    private String password;


}
