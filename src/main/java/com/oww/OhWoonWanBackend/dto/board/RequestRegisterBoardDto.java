package com.oww.OhWoonWanBackend.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestRegisterBoardDto {
    private String content;
    private Long accountId;
    private String nickname;
}
