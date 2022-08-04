package com.oww.OhWoonWanBackend.dto;

import com.oww.OhWoonWanBackend.entity.Account;
import com.oww.OhWoonWanBackend.entity.Role;

import java.io.Serializable;

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
