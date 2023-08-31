package inu890.HealthLounge.domain.Member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Member {

    private long id;    //DB에 저장할 ID

    @NotEmpty
    private String loginId;   //로그인ID

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    private String gender;

}
