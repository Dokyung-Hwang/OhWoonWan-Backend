package com.oww.OhWoonWanBackend.dto.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oww.OhWoonWanBackend.common.type.BoardType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ResponseBoardDto {

    private Long boardId;
    private String content;
    private String nickname;
    private BoardType boardType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;
}
