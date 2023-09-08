package inu890.HealthLounge.web;

import inu890.HealthLounge.domain.member.Member;
import inu890.HealthLounge.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String loginHome(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model
            ) {

        if (loginMember == null) {
            return "/home";
        }

        model.addAttribute("loginMember", loginMember);
        return "/loginHome";
    }
}
