package com.oww.OhWoonWanBackend.dto.account;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestRegisterAccountDto {

    private String email;
    private String name;
}