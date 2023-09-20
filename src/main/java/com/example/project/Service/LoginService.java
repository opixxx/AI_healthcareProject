package com.example.project.Service;

import com.example.project.domain.Member;
import com.example.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member login(String loginId, String rawPassword) {

        return memberRepository.findByLoginId(loginId)
                .filter(m -> passwordEncoder.matches(rawPassword, m.getPassword()))
                .orElse(null);
    }
}
