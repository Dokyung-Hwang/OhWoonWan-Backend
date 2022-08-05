package com.oww.OhWoonWanBackend.service;

import com.oww.OhWoonWanBackend.entity.Account;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class CustomAccountDetails implements UserDetails {

    private final Account account;

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }


    // 계정 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    // 계정 잠김 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀 번호 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    // 사용자 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 유저 권한 목록
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> "ROLE_"+ account.getRole());
        return collectors;
    }

}
