package com.example.common.Controller;

import com.example.common.Service.UserService;
import com.example.common.Vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user/**")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 회원가입 폼
     * @return
     */
    @GetMapping("/signup")
    public String signUpForm() {
        return "/user/signup";
    }

    /**
     * 회원가입 진행
     * @param user
     * @return
     */
    @PostMapping("/signup")
    public String signUp(UserVo userVo) {
        userService.joinUser(userVo);
        return "redirect:/login"; //로그인 구현 예정
        //return "/login";
    }
}
