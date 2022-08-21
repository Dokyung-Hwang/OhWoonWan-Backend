package com.oww.OhWoonWanBackend.dto.comment;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class ResponseCommentListDto {

    private List<ResponseCommentDto> commentDtoList;
}
