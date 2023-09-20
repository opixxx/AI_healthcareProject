package inu890.HealthLounge.domain.login;

import inu890.HealthLounge.domain.member.Member;
import inu890.HealthLounge.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * @return null 로그인 실패
     */
    public Member login(String loginId, String rawPassword) {

        return memberRepository.findByLoginId(loginId)
                .filter(m -> passwordEncoder.matches(rawPassword, m.getPassword()))
                .orElse(null);
    }

}
