package com.oww.OhWoonWanBackend.dto;

import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.common.type.Role;

import java.io.Serializable;

// 인증된 사용자 정보를 세션에 저장하기 위한 클래스
public class AccountSessionDto implements Serializable {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Role role;

    // Entity -> DTO
    public AccountSessionDto(Account account) {
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.nickname = account.getNickname();
        this.email = account.getEmail();
        this.role = account.getRole();
    }
}
