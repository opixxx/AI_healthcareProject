package inu890.HealthLounge.domain.signUp;

import inu890.HealthLounge.domain.member.Member;
import inu890.HealthLounge.domain.member.MemberRepository;
import inu890.HealthLounge.web.signUp.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignUpForm form) {

        // loginId 중복 체크
        if (memberRepository.findByLoginId(form.getLoginId()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 로그인 ID입니다.");
        }

        // 회원 생성
        Member member = new Member();
        member.setLoginId(form.getLoginId());
        member.setUserName(form.getUserName());
        member.setGender(form.getGender());

        // 비밀번호 암호화 후 저장
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        member.setPassword(encryptedPassword);

        memberRepository.save(member);
    }
}
