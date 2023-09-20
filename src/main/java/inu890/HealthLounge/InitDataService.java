package inu890.HealthLounge;

import inu890.HealthLounge.domain.member.Member;
import inu890.HealthLounge.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitDataService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        Member member = new Member();
        member.setLoginId("test");
        member.setUserName("Test User");
        member.setPassword(passwordEncoder.encode("test!"));
        member.setGender("male");   // 남성

        memberRepository.save(member);
    }
}
