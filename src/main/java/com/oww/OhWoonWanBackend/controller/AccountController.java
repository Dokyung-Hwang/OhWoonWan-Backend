package com.oww.OhWoonWanBackend.controller;

import com.oww.OhWoonWanBackend.dto.account.AccountSessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final HttpSession session;


    @GetMapping("/")
    public String login(Model model, HttpSession httpSession) {
        Object user = httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", (AccountSessionDto)user);
        }

        return "login";
    }
}
