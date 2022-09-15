package com.oww.OhWoonWanBackend.dto.board;

import com.oww.OhWoonWanBackend.dto.common.ResponseListDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
public class ResponseBoardListDto extends ResponseListDto {

    private List<ResponseBoardDto> boardDtoList;
}
