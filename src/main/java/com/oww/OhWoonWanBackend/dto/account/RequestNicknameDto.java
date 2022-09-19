package com.oww.OhWoonWanBackend.dto.account;

import com.oww.OhWoonWanBackend.common.type.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestNicknameDto {
    private String nickname;
    private Role role = Role.USER;
}
