package com.oww.OhWoonWanBackend.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestRegisterCommentDto {

    private String content;
    private Long accountId;
    private Long boardId;
}
