package com.oww.OhWoonWanBackend.dto;

import com.oww.OhWoonWanBackend.domain.Account;
import com.oww.OhWoonWanBackend.common.type.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Role role;

    // DTO -> Entity
    public Account toEntity() {
        Account account = Account.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(role.USER)
                .build();
        return account;
    }

}
