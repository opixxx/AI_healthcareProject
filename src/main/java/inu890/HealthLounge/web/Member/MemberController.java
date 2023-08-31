package inu890.HealthLounge.web.Member;

import inu890.HealthLounge.domain.Member.Member;
import inu890.HealthLounge.domain.Member.MemberRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    final MemberRepository memberRepository;

    @GetMapping("/sign-up")
    public String addForm(@ModelAttribute Member member) {
        return "members/signup";
    }

    @PostMapping("/sign-up")
    public String save(@Validated @ModelAttribute Member member, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "members/signup";
        }

        //로직
        memberRepository.save(member);

        return "redirect:/";
    }

}
