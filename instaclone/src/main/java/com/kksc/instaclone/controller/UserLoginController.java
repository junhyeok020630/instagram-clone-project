package com.kksc.instaclone.controller;

import com.kksc.instaclone.config.auth.PrincipalDetails;
import com.kksc.instaclone.dto.user.UserProfileDto;
import com.kksc.instaclone.entity.User;
import com.kksc.instaclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller

// 사용자 로그인과 관련된 컨트롤러
public class UserLoginController {
    private final UserService userService;
    // UserService 빈을 스프링 컨테이너에서 가져온다.(RequiredArgsConstructor를 사용하여 컨트롤러 생성 시 자동으로 빈 객체 주입)

    // 회원 가입 폼으로 이동
    @GetMapping("/signup") // /signup 요청 시
    public String signup() {
        return "signup";
    } // signup.html 응답

    // 로그인 화면으로 이동
    @GetMapping("/login") // /login 요청 시
    public String login() {
        return "login";
    } // login.html 응답

    // 메인 화면으로 이동
    @GetMapping("/") // / 요청(기본 페이지)시
    public String main(Model model) { // 응답 객체를 담아 전송할 Model 객체를 인수로 넣는다.
        List<UserProfileDto> list = new ArrayList(); // 사용자 프로필 리스트 list 생성
        List<UserProfileDto> users = new ArrayList(); // 사용자 프로필 리스트 users 생성
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // SecurityContextHolder : Spring Security가 현재 로그인한 사용자의 정보를 저장하는 공간
        // getContext().getAuthentication() 메서드를 통해 로그인한 사람의 인증 객체(Authentication)를 가져올 수 있다.

        // Authentication : 누가 로그인 했는지, 어떤 권한을 가졌는지, 인증이 되었는지, 비밀번호 등등의 정보가 담겨있다.
        PrincipalDetails user = (PrincipalDetails) authentication.getPrincipal();
        long id = user.getUser().getId();
        int i = 0;

        for (User u: userService.getUsers()) {
            UserProfileDto userProfileDto = userService.getUserProfileDto(u.getId(), id);
            if (id!=userProfileDto.getUser().getId())
                list.add(userProfileDto);
            else
                model.addAttribute("mainuser", userProfileDto);
        }

        for (UserProfileDto u: list) {
            users.add(u);
            if (i++==4)
                break;
        }

        model.addAttribute("users", users);
        return "post/home";
    }
}
