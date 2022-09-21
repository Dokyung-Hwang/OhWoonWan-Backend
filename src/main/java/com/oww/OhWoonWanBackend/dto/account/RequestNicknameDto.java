package com.oww.OhWoonWanBackend.dto.account;

import com.oww.OhWoonWanBackend.common.type.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestNicknameDto {

    private String nickname;
    private Role role = Role.USER;

    @NotBlank
    private String email;
    @NotBlank
    private Long accountId;

}
