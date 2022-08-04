package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.entity.Account;
import com.oww.OhWoonWanBackend.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    private final HttpSession session;

    // username이 DB에 있는지 확인
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + username));

        session.setAttribute("user", new UserSessionDto(user));

        // security session에 사용자 정보 저장
        return new CustomUserDetails(user);
    }

}
