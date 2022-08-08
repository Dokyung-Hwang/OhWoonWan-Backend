package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.dto.AccountDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @GetMapping("/auth/join")

    public String join() {
        return "/user/user-join";
    }

//    @PostMapping("/auth/joinProc")
//    public String joinProc(AccountDto accountDto) {
//        accountService.userJoin(accountDto);
//        return "redirect:/auth/login";
//    }

}
