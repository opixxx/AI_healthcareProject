package inu890.HealthLounge.domain.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;    //DB에 저장할 ID

    @NotEmpty
    @Column
    private String loginId;   //로그인ID

    @Column
    @NotEmpty
    private String userName;  //회원가입 시 적는 사용자 이름

    @Column
    @NotEmpty
    private String password;

    @Column
    private String gender;

}
