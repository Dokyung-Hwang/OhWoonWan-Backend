package com.oww.OhWoonWanBackend.dto.commentof;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class ResponseCommentOfListDto {

    private List<ResponseCommentOfDto> commentOfDtoList;
}
