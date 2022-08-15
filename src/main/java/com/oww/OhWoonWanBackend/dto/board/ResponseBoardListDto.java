package com.oww.OhWoonWanBackend.dto.board;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class ResponseBoardListDto {

    private List<ResponseBoardDto> boardDtoList;
}
