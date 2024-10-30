package com.app.positionback.controller.kakao;

import com.app.positionback.domain.member.MemberDTO;
import com.app.positionback.service.kakao.KakaoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;

    @GetMapping("/kakao/login")
    public RedirectView login(String code, HttpSession session){
        String token = kakaoService.getKakaoAccessToken(code);
        Optional<MemberDTO> kakaoInfo = kakaoService.getKakaoInfo(token);

        if(kakaoInfo.isPresent()){
//            memberService.join(kakaoInfo.get().toVO());
        }

//        session.setAttribute("member", memberService.getKakaoMember(kakaoInfo.get().getMemberKakaoEmail()).get());

        return new RedirectView("/member/my-page");
    }
}
